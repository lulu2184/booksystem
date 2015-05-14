package frontend.functionality;

import backend.check.CheckResult;
import backend.check.content.ValidUser;
import backend.update.*;
import frontend.Page;
import frontend.PageController;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/4.
 */
public class Login extends Update{
    public String username;
    public String password;

    public Login() {
        action_name = "Login";
    }

    protected void infoListInitialize() throws NoSuchFieldException{
        infoList.add(createDialogPair("please enter your username:", "username"));
        infoList.add(createDialogPair("please enter your password:", "password"));
    }

    protected void successUpdate(PageController pc) {
        backend.session.User.login(username);
        pc.changeCurrentPage(Page.USERMENU);
    }

    protected CheckResult actions() throws SQLException {
        return new ValidUser(username, password).check();
    }
}
