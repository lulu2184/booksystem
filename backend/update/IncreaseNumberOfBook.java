package backend.update;

import backend.check.CheckResult;
import backend.check.content.ExistingCheck;
import backend.query.NumberOfBookQuery;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/13.
 */
public class IncreaseNumberOfBook extends Update{
    private String book;
    private int qty;

    public IncreaseNumberOfBook(String book, int qty){
        this.book = book.replaceAll("'", "''");
        this.qty = qty;
    }

    protected CheckResult formatCheck(){
        if (qty < 1){
            return CheckResult.createFail("The quantity of arrival books should be a positive integer.");
        }
        return CheckResult.createSuccess();
    }

    protected CheckResult contentCheck() throws SQLException{
        if (!ExistingCheck.check("Book", "ISBN", book)){
            return CheckResult.createFail("The book is not exists.");
        }
        if (NumberOfBookQuery.query(book) > Integer.MAX_VALUE - qty){
            return CheckResult.createFail("Arrival of new copies will lead to book inventory number overflow.");
        }
        return CheckResult.createSuccess();
    }

    protected void getSQLList(){
        sqlList.add(getUpdateStatement("Book", "inum = inum + " + Integer.toString(qty), "ISBN = " + addQuotes(book)));
    }
}
