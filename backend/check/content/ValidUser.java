package backend.check.content;

import backend.exception.informationException.InformationException;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by LU on 15/5/11.
 */
public class ValidUser extends InformationChecker {
    String username;
    String password;

    public ValidUser(String _user, String _password){
        username = _user;
        password = _password;
    }

    protected String getSQLquery(){
        return "SELECT * FROM User U WHERE U.username = '" + username + "';";
    }

    protected boolean Analyze(ResultSet rs) throws SQLException, InformationException{
        if (!rs.next()){
            throw new InformationException("User not exists");
        }
        if (!password.equals(rs.getString("password"))){
            throw new InformationException("User and password is not matched.");
        }
        return true;
    }

}
