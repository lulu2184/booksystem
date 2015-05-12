package backend.check.content;

import backend.Connector;
import backend.check.CheckResult;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by LU on 15/5/12.
 */
public class ConflictCheck {
    public static CheckResult check(String table, String field, String value) throws SQLException{
        String sql = "SELECT * FROM " + table + " T" + " WHERE " + "T." + field + "='" + value + "';";
        ResultSet rs = Connector.ExecuteQuery(sql);
        if (rs.next()){
            return CheckResult.createFail("Confilct " + field + ".");
        }else{
            return CheckResult.createSuccess();
        }
    }
}
