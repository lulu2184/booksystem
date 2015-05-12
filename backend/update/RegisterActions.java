package backend.update;

import backend.check.CheckResult;
import backend.check.content.ExistingCheck;
import backend.check.format.ValidNewUser;
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

    protected String getSQL(){
        return "INSERT INTO User(username, password, fullname, age, address, phone) VALUES('" + info.username + "', '"
                + info.password + "', '" + info.fullname + "', " + info.age.toString() + ", '" + info.address + "', '"
                + info.phone + "');";
    }

    protected CheckResult formatCheck(){
        return ValidNewUser.check(info);
    }

    protected CheckResult contentCheck()throws SQLException{
        if (ExistingCheck.check("User", "username", info.username)){
            return CheckResult.createFail("Username is already exists.");
        }else{
            return CheckResult.createSuccess();
        }
    }

    protected void sessionUpdate(){
        User.login(info.username);
    }
}
