package frontend;

import backend.User.User;
import frontend.functionality.Login;
import frontend.functionality.Register;
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
    MANAGERMENU("enter manager menu"){
        boolean Do(PageController pc){
            return ManageMenu.getInstance().Do(pc);
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
    REGISTER("register"){
        boolean Do(PageController pc){
            try{
                new Register().Do(pc);
            } catch (NoSuchFieldException e){
                System.err.println(e.getMessage());
            }
            return true;
        }
    };
  //  LOGIN,
   // REGISTER;
    private final String message;
    private User user = null;

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
