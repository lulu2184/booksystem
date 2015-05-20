package backend.update;

import backend.check.CheckResult;
import backend.check.content.ExistingCheck;
import backend.query.NumberOfBookQuery;
import backend.session.Order;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/12.
 */
public class InsertABookInOrder extends Update{
    private String book;
    private int qty;

    public InsertABookInOrder(String book, int qty){
        this.book = book.replaceAll("'", "''");
        this.qty = qty;
    }

    protected CheckResult formatCheck(){
        if (qty < 1){
            return CheckResult.createFail("This quantity is not valid.");
        }
        return CheckResult.createSuccess();
    }

    protected void getSQLList() throws SQLException{
        String sql;
        String orderid = Order.getOrderString();
        if (ExistingCheck.checkPair("InOrder", "orderid", Order.getOrderString(), "ISBN", addQuotes(book))){
            sql = "UPDATE InOrder SET num = num + " + Integer.toString(qty) + " WHERE ISBN = '" + book + "' AND orderid = " + orderid + ";";
        }else {
            sql = "INSERT INTO InOrder(orderid, ISBN, num) VALUES(" + orderid + ", '" + book + "', " + Integer.toString(qty) + ");";
        }
        sqlList.add(sql);
        sql = "UPDATE Book SET inum = inum - " + Integer.toString(qty) + " WHERE ISBN = '" + book + "';";
        sqlList.add(sql);
    }

    protected CheckResult contentCheck()throws SQLException{
//        if (!ExistingCheck.checkNumber("Orders", "orderid", Order.getOrderString())){
//            return CheckResult.createFail("Order not exists.");
//        }
        if (!ExistingCheck.check("Book", "ISBN", book)){
            return CheckResult.createFail("Book not exists.");
        }
        if (NumberOfBookQuery.query(book) < qty){
            return CheckResult.createFail("Not enough book or no such book.");
        }
        return CheckResult.createSuccess();
    }
}
