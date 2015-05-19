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
        menu = new Page[]{Page.CREATE_NEW_BOOK, Page.NEW_COPIES_ARRIVAL, Page.USEFUL_FEEDBACK, Page.AUTHOR_DEGREE, Page.POP_BOOK_IN_SEMESTER,
                           Page.POP_AUTHOR_IN_SEMESTER, Page.POP_PUBLISHER_IN_SEMESTER, Page.TRUSTER_USER, Page.USEFUL_USER };
        message = "  manager page";
        exitmessage = "exit manager page.";
    }

    public String getMessage(){
        return message;
    }
}
