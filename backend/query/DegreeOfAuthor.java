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
        this.author1 = author1.replaceAll("'", "''");
        this.author2 = author2.replaceAll("'", "''");
    }

    private CheckResult check() throws SQLException{
        if (!ExistingCheck.check("AuthorOf", "aname", author1)){
            return CheckResult.createFail("the first author(" + author1 + ") is not exists.");
        }
        if (!ExistingCheck.check("AuthorOf", "aname", author2)){
            return CheckResult.createFail("the second author(" + author2 + ") is not exists.");
        }
        return CheckResult.createSuccess();
    }

    private boolean linked(String from_clause, String where_clause) throws SQLException{
        String sql = "SELECT * FROM " + from_clause + " WHERE " + where_clause + ";";
        ResultSet rs = Connector.ExecuteQuery(sql);
        return rs.next();
    }

    public CheckResult query() throws SQLException{
        CheckResult result = check();
        if (!result.isValid()){
            return result;
        }
        if (author1.equals(author2)){
            return CheckResult.createSuccess("0");
        }
        String from_clause = "AuthorOf A1, AuthorOf A0";
        String where_clause = "A1.aname = '" + author1 + "' AND A1.ISBN = A0.ISBN AND A0.aname = '" + author2 + "'";
        if (linked(from_clause, where_clause)){
            return CheckResult.createSuccess("1");
        }
        from_clause = "AuthorOf A1, AuthorOf A2, AuthorOf A3, AuthorOf A0";
        where_clause = "A1.aname = '" + author1 +  "' AND A1.ISBN = A2.ISBN AND A2.aname = A3.aname AND A3.ISBN = A0.ISBN AND A0.aname = '" + author2 + "'";
        if (linked(from_clause,where_clause)){
            return CheckResult.createSuccess("2");
        }
        return CheckResult.createSuccess("more than 2");
    }

}
