package frontend;

import frontend.functionality.Login;
import frontend.functionality.Register;
import frontend.functionality.InsertInOrder;
import frontend.menu.MainMenu;
import frontend.menu.ManageMenu;
import frontend.menu.OrderMenu;
import frontend.menu.UserMenu;

import java.util.EmptyStackException;

/**
 * Created by LU on 15/5/3.
 */
public enum Page {
    MAINMENU("Book Store Manage System"){
       boolean Do(PageController pc) throws EmptyStackException{
            return MainMenu.getInstance().display(pc);
       }
    },
    USERMENU("Book Store Manage System ---- User Page"){
        boolean Do(PageController pc){
            UserMenu.getInstance().display(pc);
            return true;
        }
    },
    MANAGERMENU("enter manager menu"){
        boolean Do(PageController pc){
            return ManageMenu.getInstance().display(pc);
        }
    },
    LOGIN("login"){
        boolean Do(PageController pc){
            try {
                new Login().Do(pc);
            } catch (NoSuchFieldException e) {
                System.err.println("No Such Field " + e.getMessage());
                pc.exitCurrentPage();
            }
            return true;
        }
    },
    REGISTER("register"){
        boolean Do(PageController pc){
            try{
                new Register().Do(pc);
            } catch (NoSuchFieldException e){
                System.err.println("No Such Field " + e.getMessage());
                pc.exitCurrentPage();
            }
            return true;
        }
    },
    ORDERMENU("start an order."){
        boolean Do(PageController pc){
            return OrderMenu.getInstance().display(pc);
        }
    },
    INSERT_IN_ORDER("insert a book into current order."){
        boolean Do(PageController pc) {
            try{
                new InsertInOrder().Do(pc);
            }catch (NoSuchFieldException e){
                System.err.println("No Such Field " + e.getMessage());
                pc.exitCurrentPage();
            }
            return true;
        }
    };

    private final String message;

    Page(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

    protected void displayTitile(){
        System.out.println("             Database book manage system");
    }

    abstract boolean Do(PageController pc);

}
