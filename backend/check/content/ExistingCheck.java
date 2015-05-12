package backend.check.content;

import backend.Connector;
import backend.check.CheckResult;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by LU on 15/5/12.
 */
public class ExistingCheck {
    private static boolean execute(String sql)throws SQLException{
        ResultSet rs = Connector.ExecuteQuery(sql);
        if (rs.next()){
            return true;
        }else{
            return false;
        }
    }

    public static boolean check(String table, String field, String value) throws SQLException{
        String sql = "SELECT * FROM " + table + " T" + " WHERE " + "T." + field + "='" + value + "';";
        return execute(sql);
    }

    public static boolean checkNumber(String table, String field, String value) throws SQLException{
        String sql = "SELECT * FROM " + table + " T" + " WHERE " + "T." + field + "=" + value + ";";
        return execute(sql);
    }
}
