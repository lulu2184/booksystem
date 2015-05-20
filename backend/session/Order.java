package backend.session;

import backend.Connector;
import backend.GenerateNewID;

import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Created by LU on 15/5/12.
 */
public class Order {
    private long orderid;
    private static Order oneInstance = null;
    private static SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Order(long orderid){
        this.orderid = orderid;
    }

    public static long getOrderid()throws NullPointerException, SQLException{
        return getInstance().orderid;
    }

    public static String getOrderString() throws NullPointerException, SQLException{
        return Long.toString(getOrderid());
    }

    private static Order getInstance() throws NullPointerException, SQLException{
        if (oneInstance == null) {
            createNewOrder();
        }
        return oneInstance;
    }

    public static long createNewOrder() throws SQLException{
        long ID = createNewOrderID();
        oneInstance = new Order(ID);
        return ID;
    }

    public static void finishOrder(){
        oneInstance = null;
    }

    private static long createNewOrderID() throws SQLException{
        Date date = new Date();
        long orderid = GenerateNewID.generate();
        String sql = "INSERT INTO Orders(orderid, order_date, username) VALUES(" + Long.toString(orderid) + ", '"
                + dateformat.format(date) + "', '" + User.getUsername().replaceAll("'", "''") + "');";
        Connector.ExecuteInsertion(sql);
        return orderid;
    }
}
