package backend.update;

import backend.check.CheckResult;
import backend.check.format.ValidNewUser;
import backend.info.UserInfo;
import backend.session.User;

/**
 * Created by LU on 15/5/12.
 */
public class Register extends Update{
    private UserInfo info;

    public Register(UserInfo info){
        this.info = info;
    }

    protected String getSQL(){
        return "INSERT INTO User(username, password, fullname, age, address, phone) VALUES('" + info.username + "', '"
                + info.password + "', '" + info.fullname + "', " + info.age.toString() + ", '" + info.address + "', '"
                + info.phone + "');";
    }

    protected CheckResult check(){
        return ValidNewUser.check(info);
    }

    protected void sessionUpdate(){
        User.login(info.username);
    }
}
