package backend.session;

/**
 * Created by LU on 15/5/12.
 */
public class User {
    private String username;
    private static User oneInstance = null;

    private User(String username){
        this.username = username;
    }

    public static String getUsername(){
        return getInstance().Username();
    }

    private String Username(){
        return username;
    }

    private static User getInstance() throws NullPointerException{
        if (oneInstance == null){
            throw new NullPointerException("user oneInstance is null.");
        }
        return oneInstance;
    }

    public static void login(String username){
        oneInstance = new User(username);
    }

    public static void logout(){
        oneInstance = null;
    }


}
