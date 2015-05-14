package frontend.functionality;

import frontend.PageController;

/**
 * Created by LU on 15/5/10.
 */
abstract public class Order extends Update{
    public String ISBN;
    public Integer quantity;

    public Order(){
    }

    protected void infoListInitialize() throws NoSuchFieldException{
        infoList.add(createDialogPair("please enter a book ISBN:", "ISBN"));
        infoList.add(createDialogPair("please enter the quantity of this book you want to order:", "quantity"));
    }
}
