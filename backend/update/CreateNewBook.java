package backend.update;


import backend.Connector;
import backend.check.CheckResult;
import backend.check.content.ExistingCheck;
import backend.check.format.ValidNewBook;
import backend.info.BookInfo;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/12.
 */
public class CreateNewBook extends Update{
    private BookInfo info;

    public CreateNewBook(BookInfo info){
        this.info = info;
    }

    protected CheckResult formatCheck(){
        return ValidNewBook.check(info);
    }

    protected CheckResult contentCheck() throws SQLException{
        if (ExistingCheck.check("Book", "ISBN", info.ISBN)){
            return CheckResult.createFail("This book is already exists.");
        }
        if (!ExistingCheck.check("Publisher", "pname", info.pname)){
            return CheckResult.createFail("This publisher not exists.");
        }
        return CheckResult.createSuccess();
    }

    protected void getSQLList(){
        String sql = getInsertStatement("Book", BookInfo.getColumnsFormat(), info.getInsertFormat());
        sqlList.add(sql);
    }

}