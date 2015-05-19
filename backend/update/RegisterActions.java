package backend.update;

import backend.check.CheckResult;
import backend.check.content.ExistingCheck;
import backend.info.UserInfo;
import backend.session.User;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/12.
 */
public class RegisterActions extends Update{
    private UserInfo info;

    public RegisterActions(UserInfo info){
        this.info = info;
    }

    protected void getSQLList(){
        String sql = getInsertStatement("User", "username, password, fullname, age, address, phone", info.getInsertFormat());
        sqlList.add(sql);
    }

    protected CheckResult formatCheck(){
        return info.check();
    }

    protected CheckResult contentCheck()throws SQLException{
        if (ExistingCheck.check("User", "username", info.username.replaceAll("'", "''"))){
            return CheckResult.createFail("Username is already exists.");
        }else{
            return CheckResult.createSuccess();
        }
    }

    protected void sessionUpdate(){
        User.login(info.username);
    }
}
