package frontend.list;

import frontend.Page;
import frontend.PageController;
import frontend.functionality.Order;

/**
 * Created by LU on 15/5/10.
 */
public class OrderMenu extends List{

    public OrderMenu(){
        message = "Welcome to order menu, ";
        menu = new Page[]{};
    }

    public String getMessage(PageController pc){
        return message + pc.getUserName();
    }
}
