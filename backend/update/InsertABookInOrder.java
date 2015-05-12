package backend.update;

import backend.check.CheckResult;
import backend.check.content.ExistingCheck;
import backend.session.Order;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/12.
 */
public class InsertABookInOrder extends Update{
    private String book;
    private int qty;

    public InsertABookInOrder(String book, int qty){
        this.book = book;
        this.qty = qty;
    }

    protected CheckResult formatCheck(){
        if (qty < 0){
            return CheckResult.createFail("The quantity is not valid number.");
        }
        return CheckResult.createSuccess();
    }

    protected String getSQL() throws SQLException{
        return "INSERT INTO InOrder(username, ISBN, num) VALUES('" + Order.getOrderString() + "', '" + book + "', " + Integer.toString(qty) + ");";
    }

    protected CheckResult contentCheck()throws SQLException{
        if (!ExistingCheck.checkNumber("Orders", "orderid", Order.getOrderString())){
            return CheckResult.createFail("Order not exists.");
        }
        if (!ExistingCheck.check("Book", "ISBN", book)){
            return CheckResult.createFail("Book not exists.");
        }
        return CheckResult.createSuccess();
    }
}
