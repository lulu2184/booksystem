package backend.order;

import backend.Connector;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/11.
 */
public enum InsertInOrder {

    VALID(""),
    BOOKNOTEXITS("the book is not exits."){
        boolean violate(long orderid, String ISBN, int qty)throws SQLException{
            String sql = "SELECT * FROM Book WHERE ISBN = " + ISBN + ";";
            Connector.ExecuteQuery(sql);
           // if ()
            return false;
        }
    },
    ALREADY_IN_ORDER("this book is already in this order."),
    SQL_ERROR("SQL error(s) occurs.");

    private String message;

    InsertInOrder(String _message){
        message = _message;
    }

    boolean violate(long orderid, String ISBN, int qty) throws SQLException{
        return false;
    }

    public static InsertInOrder insert(long orderid, String ISBN, int qty){
       // verify()
        return VALID;
    }
}
