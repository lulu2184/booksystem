package frontend.functionality;

import backend.check.CheckResult;
import backend.info.UserInfo;
import backend.session.User;
import backend.update.RegisterActions;
import frontend.Page;
import frontend.PageController;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/4.
 */
public class Register extends InterativeForm {
    public String username;
    public String password;
    public String fullname;
    public Integer age;
    public String address;
    public String phone;

    public Register() throws NoSuchFieldException{
        action_name = "register";
        infoList.add(createDialogPair("please enter your username;","username"));
        infoList.add(createDialogPair("please enter your password:", "password"));
        infoList.add(createDialogPair("please enter your fullname:", "fullname"));
        infoList.add(createDialogPair("please enter your age:", "age"));
        infoList.add(createDialogPair("please enter your address:", "address"));
        infoList.add(createDialogPair("please enter your phone number:", "phone"));
    }

    protected void successUpdate(PageController pc){
        pc.changeCurrentPage(Page.USERMENU);
        User.login(username);
    }

    protected CheckResult actions()throws SQLException{
        UserInfo userinfo = new UserInfo(username, password, fullname, age, address, phone);
        return new RegisterActions(userinfo).actions();
    }
}
