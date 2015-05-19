package backend.update;


import backend.check.CheckResult;
import backend.check.content.ExistingCheck;
import backend.check.format.DuplicateChecker;
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
        if (!DuplicateChecker.check(info.author)){
            return CheckResult.createFail("Duplicate authors.");
        }
        return info.check();
    }

    protected CheckResult contentCheck() throws SQLException{
        if (ExistingCheck.check("Book", "ISBN", info.ISBN)){
            return CheckResult.createFail("This book is already exists.");
        }
        return CheckResult.createSuccess();
    }

    protected void getSQLList(){
        String sql = getInsertStatement("Book", BookInfo.getColumnsFormat(), info.getInsertFormat());
        sqlList.add(sql);
        for (String author : info.author){
            author = author.replaceAll("'", "''");
            sql = getInsertStatement("AuthorOf", "aname, ISBN", addQuotes(author) + ", " + addQuotes(info.ISBN));
            sqlList.add(sql);
        }
    }

}
