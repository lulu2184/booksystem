package frontend.list;

import frontend.Input;
import frontend.Page;
import frontend.PageController;

import java.io.IOException;
import java.util.EmptyStackException;

/**
 * Created by LU on 15/5/3.
 */
public class List {
    protected Page[] menu = {Page.MANAGERMENU};
    protected String message = "";

    public List(){

    }

    protected void display(Page[] menu){
        for (int i = 0; i < menu.length; ++i){
            System.out.println(Integer.toString(i + 1) + ". " + menu[i].getMessage());
        }
        System.out.println(Integer.toString(menu.length + 1) + ". exit this menu.");
    }

    protected int getChoice() throws IOException, NumberFormatException{
        return Input.getInt();
    }

    protected boolean transfer(PageController pc) throws EmptyStackException{
        int c = 0;
        boolean result = false;
        try{
            c = getChoice() - 1;
            if (c >= 0 && c < menu.length){
                pc.changeCurrentPage(menu[c]);
            }else if (c == menu.length){
                result = pc.exitCurrentPage();
            }else{
                System.out.println("Wrong number.");
            }
        } catch (IOException e){
            System.err.println("IOException while getting your choice.");
        } catch (NumberFormatException e){
            System.err.println("Wrong number format.");
        }
        return result;
    }

    public boolean Do(PageController pc){
        System.out.println(message);
        display(menu);
        return transfer(pc);
    }
}
