package frontend.list;

import frontend.Page;
import frontend.PageController;

/**
 * Created by LU on 15/5/4.
 */
public class UserMenu extends Menu {
    private static String username;
    private static UserMenu oneInstance = null;

    private UserMenu() {
        menu = new Page[]{};
        message = "welcome, ";
        exitmessage = "logout";
    }

    public static UserMenu getInstance() {
        if (oneInstance == null) {
            oneInstance = new UserMenu();
        }
        return oneInstance;
    }

    public String getMessage(PageController pc) {
        return this.message + pc.getUserName();
    }
}
