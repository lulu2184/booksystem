package backend.check.content;

import backend.check.CheckResult;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by LU on 15/5/11.
 */
public class ValidUser extends InformationChecker {
    String username;
    String password;

    public ValidUser(String _user, String _password){
        username = _user.replaceAll("'", "''");
        password = _password;
    }

    protected String getSQLquery(){
        return "SELECT * FROM User U WHERE U.username = '" + username + "';";
    }

    protected CheckResult Analyze(ResultSet rs) throws SQLException{
        if (!rs.next()){
            return new CheckResult(false, "User not exists");
        }
        if (!password.equals(rs.getString("password"))){
            return new CheckResult(false, "User and password is not matched.");
        }
        return new CheckResult(true, "");
    }

}
