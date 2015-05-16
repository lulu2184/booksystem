package frontend.menu;

import frontend.Page;
import frontend.PageController;

/**
 * Created by LU on 15/5/3.
 */
public class MainMenu extends Menu {

    static private MainMenu oneInstance = null;

    static public MainMenu getInstance(){
        if (oneInstance == null) {
            oneInstance = new MainMenu();
        }
        return oneInstance;
    }

    private MainMenu(){
        menu = new Page[] {Page.LOGIN, Page.REGISTER, Page.MANAGERMENU, Page.BOOK_BROWSING, Page.USEFUL_FEEDBACK, Page.AUTHOR_DEGREE};
        message = "Welcome to book database system";
        exitmessage = "exit this system.";
    }

    public String getMessage(){
        return message;
    }
}
