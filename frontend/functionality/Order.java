package frontend.functionality;

import frontend.PageController;

/**
 * Created by LU on 15/5/10.
 */
abstract public class Order extends InterativeForm {
    protected String ISBN;
    protected Integer quantity;

    public Order()throws NoSuchFieldException{
        infoList.add(createDialogPair("please enter a book ISBN:", "ISBN"));
        infoList.add(createDialogPair("please enter the quantity of " + ISBN + " you want to order:", "quantity"));
    }
}
