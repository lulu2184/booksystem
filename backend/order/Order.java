package backend.order;

/**
 * Created by LU on 15/5/11.
 */
public class Order {
    private static Order oneInstance = null;
    private int orderid;

    private Order(){

    }

    public static void finishOrder(){
        oneInstance = null;
    }

    public static Order getCurrentOrder(){
        return oneInstance;
    }

}
