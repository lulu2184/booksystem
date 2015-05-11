package frontend.list;

import frontend.Page;
import frontend.PageController;

/**
 * Created by LU on 15/5/10.
 */
public class OrderMenu extends Menu {

    private static OrderMenu oneInstance = null;

    public OrderMenu getInstance(){
        if (oneInstance == null){
            oneInstance = new OrderMenu();
        }
        return oneInstance;
    }

    private OrderMenu(){
        message = "Welcome to order menu, ";
        menu = new Page[]{};
        exitmessage = "finish this order.";
    }

    public String getMessage(PageController pc){
        return message + pc.getUserName();
    }
}