package frontend.list;

import frontend.Page;
import frontend.PageController;

import java.io.IOException;

/**
 * Created by LU on 15/5/3.
 */
public class MainMenu extends List{
//    public static Page[] menu = {Page.LOGIN, Page.MANAGERMENU};
//    public static String message = "";

    static private MainMenu oneInstance = null;

    static public MainMenu getInstance(){
        if (oneInstance == null) {
            oneInstance = new MainMenu();
        }
        return oneInstance;
    }

    private MainMenu(){
        menu = new Page[] {Page.LOGIN, Page.REGISTER, Page.MANAGERMENU};
        message = "";
    }

    public String getMessage(PageController pc){
        return message;
    }

//    public boolean Do(PageController pc){
//        display(menu);
//        return transfer(pc, menu);
//    }
}
