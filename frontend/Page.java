package frontend;

import frontend.functionality.Login;
import frontend.list.List;
import frontend.list.MainMenu;
import frontend.list.ManageMenu;
import frontend.list.UserMenu;

import java.util.EmptyStackException;

/**
 * Created by LU on 15/5/3.
 */
public enum Page {
    MAINMENU("Book Store Manage System"){
       boolean Do(PageController pc) throws EmptyStackException{
            return MainMenu.getInstance().Do(pc);
       }
    },
    USERMENU("Book Store Manage System ---- User Page"){
        boolean Do(PageController pc){
            UserMenu.getInstance().Do(pc);
            return true;
        }
    },
    LOGIN("login"){
        boolean Do(PageController pc){
            try {
                new Login().Do(pc);
            } catch (NoSuchFieldException e) {
                System.err.println(e.getMessage());
            }
            return true;
        }
    },
    MANAGERMENU("enter manager menu"){
        boolean Do(PageController pc){
            return ManageMenu.getInstance().Do(pc);
        }
    };
  //  LOGIN,
   // REGISTER;
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
