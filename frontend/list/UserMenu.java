package frontend.list;

import frontend.Page;

/**
 * Created by LU on 15/5/4.
 */
public class UserMenu extends List{
    private static String username;
    private static UserMenu oneInstance = null;

    private UserMenu(){
        menu = new Page[]{};
    }

    public static UserMenu getInstance(){
        if (oneInstance == null){
            oneInstance = new UserMenu();
        }
        return oneInstance;
    }

    public void setUsername(String user){
        this.username = user;
        this.message = "Welcome, " + username;
    }

    public static void login(String user){
        getInstance().setUsername(username);
    }

    public static void logout(){
        oneInstance = null;
    }
}
