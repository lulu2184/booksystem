package backend.order;

import backend.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by LU on 15/5/11.
 */
public class Order {
    private static Order oneInstance = null;
    private static int counter = 0;
    private final static int milis_limit = 1000;
    private static SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
    private long orderid;
    private String username;

    private Order(String username) throws SQLException{
        Date date = new Date();
        orderid = date.getTime() * milis_limit + counter;
        counter = (counter + 1) % milis_limit;
        insertOrder(date);
    }

    private void insertOrder(Date date) throws SQLException{
        String sql = "INSERT INTO Orders(orderid, order_date, username) VALUES(" + Long.toString(orderid) + ", '"
                    + dateformat.format(date) + "', '" + username + "');";
        Connector.ExecuteInsertion(sql);
    }

    public static void finishOrder() {
        oneInstance = null;
    }

    public String getUsername(){
        return username;
    }

    public static Order getCurrentOrder(String username) throws SQLException{
        if (oneInstance == null || !oneInstance.getUsername().equals(username)){
            oneInstance = new Order(username);
        }
        return oneInstance;
    }

}
