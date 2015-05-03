package frontend;

import frontend.list.List;
import frontend.list.MainMenu;
import frontend.list.ManageMenu;

import java.util.EmptyStackException;

/**
 * Created by LU on 15/5/3.
 */
public enum Page {
    MAINMENU("Book Store Manage System"){
       boolean Do(PageController pc) throws EmptyStackException{
            return new MainMenu().Do(pc);
       }
    },
//    USERMENU("Book Store Manage System ---- User Page"){
//        boolean Do(PageController pc){
//            return new
//        }
//    },
    LOGIN("login"){
        boolean Do(PageController pc){
            return true;
        }
    },
    MANAGERMENU("enter manager menu"){
        boolean Do(PageController pc){
            return new ManageMenu().Do(pc);
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
