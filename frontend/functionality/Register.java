package frontend.functionality;

import backend.check.CheckResult;
import backend.info.UserInfo;
import backend.update.RegisterActions;
import frontend.Page;
import frontend.PageController;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/4.
 */
public class Register extends InterativeForm {
    String username;
    String password;
    String fullname;
    Integer age;
    String address;
    String phone;

    public Register() throws NoSuchFieldException{
        infoList.add(createDialogPair("please enter your username;","username"));
        infoList.add(createDialogPair("please enter your password:", "password"));
        infoList.add(createDialogPair("please enter your fullname:", "fullname"));
        infoList.add(createDialogPair("please enter your age:", "age"));
        infoList.add(createDialogPair("please enter your address:", "address"));
        infoList.add(createDialogPair("please enter your phone number:", "phone"));
    }

    public void execute(PageController pc){
        UserInfo userinfo = new UserInfo(username, password, fullname, age, address, phone);
        try {
            CheckResult result = new RegisterActions(userinfo).actions();
            if (result.isValid()){
                System.out.println("Successful to register.");
                pc.changeCurrentPage(Page.USERMENU);
            }else {
                System.out.println("Unsuccessful to register. " + result.getMessage());
            }
        }catch (SQLException e){
            System.out.println("Unsuccessful to register. SQL exception:");
            System.err.println(e.getMessage());
        }

    }
}
