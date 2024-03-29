package frontend.menu;

import frontend.Input;
import frontend.Page;
import frontend.PageController;

import java.io.IOException;
import java.util.EmptyStackException;

/**
 * Created by LU on 15/5/3.
 */
abstract public class Menu {
    protected Page[] menu = {Page.MANAGERMENU, Page.AUTHOR_DEGREE};
    protected String message = "";
    protected String exitmessage = "";

    public Menu(){

    }

    protected void showText(Page[] menu){
        for (int i = 0; i < menu.length; ++i){
            System.out.println(Integer.toString(i + 1) + ". " + menu[i].getMessage());
        }
        System.out.println(Integer.toString(menu.length + 1) + ". " + exitmessage);
        System.out.println("please enter your choice:");
    }

    protected int getChoice() throws IOException, NumberFormatException{
        return Input.getInt();
    }

    protected boolean transfer(PageController pc) throws EmptyStackException{
        int c = 0;
        boolean result = true;
        try{
            c = getChoice() - 1;
            if (c >= 0 && c < menu.length){
                pc.changeCurrentPage(menu[c]);
            }else if (c == menu.length){
                result = pc.exitCurrentPage();
                exitActions(pc);
            }else{
                System.out.println("Wrong number.");
            }
        } catch (IOException e){
            System.err.println("IOException while getting your choice.");
        } catch (NumberFormatException e){
            System.out.println("Wrong number format.");
        }
        return result;
    }

    public boolean display(PageController pc){
        System.out.println();
        System.out.println(getMessage());
        showText(menu);
        return transfer(pc);
    }

    protected void exitActions(PageController pc){}

    abstract public String getMessage();
}
