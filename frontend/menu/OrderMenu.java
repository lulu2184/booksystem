package frontend.menu;

import backend.session.User;
import frontend.Page;
import backend.session.Order;

/**
 * Created by LU on 15/5/10.
 */
public class OrderMenu extends Menu {

    private static OrderMenu oneInstance = null;

    public static OrderMenu getInstance(){
        if (oneInstance == null){
            oneInstance = new OrderMenu();
        }
        return oneInstance;
    }

    private OrderMenu(){
        message = "Welcome to order menu, ";
        menu = new Page[]{Page.INSERT_IN_ORDER};
        exitmessage = "finish this order.";
    }

    public String getMessage(){
        return message + User.getUsername();
    }

    protected void prepareForExit(){
        Order.finishOrder();
    }
}