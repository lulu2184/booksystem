package frontend.list;

import frontend.Page;
import frontend.PageController;

/**
 * Created by LU on 15/5/3.
 */
public class ManageMenu extends List{
//    public static Page[] menu = {};
//    public static String message = "--welcom to manage page--";

    static private ManageMenu oneInstance = null;

    static public ManageMenu getInstance(){
        if (oneInstance == null){
            oneInstance = new ManageMenu();
        }
        return oneInstance;
    }

    private ManageMenu(){
        //menu = new Page[]{};
        menu = new Page[]{Page.LOGIN};
        message = "  manage page";
    }



//    public boolean Do(PageController pc){
//        System.out.println("--welcom to manage page--");
//        display(menu);
//        return transfer(pc, menu);
//    }
}
