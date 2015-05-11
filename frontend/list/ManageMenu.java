package frontend.list;

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
        menu = new Page[]{Page.LOGIN};
        message = "  manage page";
        exitmessage = "exit manager menu.";
    }

    public String getMessage(PageController pc){
        return message;
    }
}
