package frontend.menu;

import frontend.Page;
import frontend.PageController;

/**
 * Created by LU on 15/5/3.
 */
public class ManageMenu extends Menu {

    static private ManageMenu oneInstance = null;

    static public ManageMenu getInstance(){
        if (oneInstance == null){
            oneInstance = new ManageMenu();
        }
        return oneInstance;
    }

    private ManageMenu(){
        menu = new Page[]{Page.CREATE_NEW_BOOK, Page.NEW_COPIES_ARRIVAL};
        message = "  manage page";
        exitmessage = "exit manager menu.";
    }

    public String getMessage(){
        return message;
    }
}
