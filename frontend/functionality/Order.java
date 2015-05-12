package frontend.functionality;

import frontend.PageController;

/**
 * Created by LU on 15/5/10.
 */
public class Order extends InterativeForm {
    private String username;
    private String ISBN;
    private Integer quantity;

    public Order(String _username)throws NoSuchFieldException{
        username = _username;
        infoList.add(createDialogPair("please enter a book ISBN:", "ISBN"));
        infoList.add(createDialogPair("please enter the quantity of " + ISBN + " you want to order:", "quantity"));
    }

    protected void execute(PageController pc){

    }
}
