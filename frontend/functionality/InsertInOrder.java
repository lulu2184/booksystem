package frontend.functionality;

import backend.check.CheckResult;
import backend.update.InsertABookInOrder;
import frontend.PageController;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/11.
 */
public class InsertInOrder extends Order {

    public InsertInOrder(String ISBN, int qty) throws NoSuchFieldException{
        super(ISBN, qty);
        action_name = "insert a book into order.";
    }

    protected void successUpdate(PageController pc){

    }

    protected CheckResult actions() throws SQLException{
        return new InsertABookInOrder(ISBN, quantity).actions();
    }
}
