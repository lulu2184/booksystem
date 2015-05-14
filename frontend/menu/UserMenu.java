package frontend.menu;

import backend.session.User;
import frontend.Page;

/**
 * Created by LU on 15/5/4.
 */
public class UserMenu extends Menu {
    private static String username;
    private static UserMenu oneInstance = null;

    private UserMenu() {
        menu = new Page[]{Page.ORDERMENU, Page.GIVE_FEEDBACK, Page.RATE_FOR_FEEDBACK, Page.DECLARE_USER, Page.USEFUL_FEEDBACK};
        message = "welcome, ";
        exitmessage = "logout";
    }

    public static UserMenu getInstance() {
        if (oneInstance == null) {
            oneInstance = new UserMenu();
        }
        return oneInstance;
    }

    public String getMessage(){
        return this.message + User.getUsername();
    }
}
