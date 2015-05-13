package frontend.functionality;

import backend.check.CheckResult;
import backend.update.IncreaseNumberOfBook;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/13.
 */
public class CopiesArrival extends InterativeForm{

    public String book;
    public Integer qty;

    public CopiesArrival() throws NoSuchFieldException{
        action_name = "increase the inventory number of this book";
        infoList.add(createDialogPair("please enter the ISBN of the book which have more copies arrival:", "book"));
        infoList.add(createDialogPair("please enter the quantity of new copies:", "qty"));
    }

    protected CheckResult actions() throws SQLException{
        return new IncreaseNumberOfBook(book, qty).actions();
    }
}
