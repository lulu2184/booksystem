package backend.session;

import java.util.Date;

/**
 * Created by LU on 15/5/12.
 */
public class Order {
    private long orderid;
    private static Order oneInstance = null;
    private final static long milis_limit = 1000L;
    private static long counter = 0;

    private Order(long orderid){
        this.orderid = orderid;
    }

    public static long getOrderid()throws NullPointerException{
        return getInstance().orderid;
    }

    public static String getOrderString() throws NullPointerException{
        return Long.toString(getOrderid());
    }

    private static Order getInstance() throws NullPointerException{
        if (oneInstance == null) {
            throw new NullPointerException("order oneInstance is null.");
        }
        return oneInstance;
    }

    public static long createNewOrder(){
        long ID = createNewOrderID();
        oneInstance = new Order(ID);
        return ID;
    }

    public static void finishOrder(){
        oneInstance = null;
    }

    private static long createNewOrderID(){
        Date date = new Date();
        long orderid = date.getTime() * milis_limit + counter;
        counter = (counter + 1) % milis_limit;
        return orderid;
    }
}
