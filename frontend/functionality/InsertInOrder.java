package frontend.functionality;

import backend.check.CheckResult;
import backend.session.BookInOrder;
import backend.update.InsertABookInOrder;
import frontend.Page;
import frontend.PageController;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/11.
 */
public class InsertInOrder extends Order {

    public InsertInOrder(){
        action_name = "Insert Book Into Order";
    }

    protected void successUpdate(PageController pc){
        BookInOrder.setBook(ISBN);
        pc.changeCurrentPage(Page.BUYING_SUGGESTION);
    }

    protected CheckResult actions() throws SQLException{
        return new InsertABookInOrder(ISBN, quantity).actions();
    }
}
