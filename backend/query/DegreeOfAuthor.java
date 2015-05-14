package backend.query;

import backend.Connector;
import backend.check.CheckResult;
import backend.check.content.ExistingCheck;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by LU on 15/5/14.
 */
public class DegreeOfAuthor{
    private String author1;
    private String author2;

    public DegreeOfAuthor(String author1, String author2){
        this.author1 = author1;
        this.author2 = author2;
    }

    private CheckResult check() throws SQLException{
        if (!ExistingCheck.check("Author", "aname", author1)){
            return CheckResult.createFail("the first author(" + author1 + ") is not exists.");
        }
        if (!ExistingCheck.check("Author", "aneme", author2)){
            return CheckResult.createFail("the second author(" + author2 + ") is not exists.");
        }
        return CheckResult.createSuccess();
    }

    private boolean linked(String from_clause, String where_clause) throws SQLException{
        String sql = "SELECT COUNT(*) FROM " + from_clause + " WHERE " + where_clause + ";";
        ResultSet rs = Connector.ExecuteQuery(sql);
        return rs.next();
    }

    public CheckResult query() throws SQLException{
        CheckResult result = check();
        if (!result.isValid()){
            return result;
        }
        if (author1 == author2){
            return result.createSuccess("0");
        }
        String from_clause = "AuthorOf A1, Book B1, AuthorOf A0";
        String where_clause = "A1.aname = '" + author1 + "' AND A1.ISBN = B1.ISBN AND B1.ISBN = A0.ISBN AND A0.aname = '" + author2 + "'";
        if (linked(from_clause, where_clause)){
            return result.createSuccess("1");
        }
        from_clause = "AuthorOf A1, Book B1, AuthorOf A2, Book B2, Author A0";
        where_clause = "A1.aname = '" + author1 +  "' AND A1.ISBN = B1.ISBN AND B1.ISBN = A1.ISBN AND A2.ISBN = B2.ISBN AND B2.ISBN = A0.ISBN AND A0.aname = '" + author2 + "'";
        if (linked(from_clause,where_clause)){
            return result.createSuccess("2");
        }
        return result.createSuccess("more than 2");
    }

}
