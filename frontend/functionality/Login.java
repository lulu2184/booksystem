package frontend.functionality;

import backend.check.CheckResult;
import backend.check.content.ValidUser;
import backend.user.User;
import frontend.Page;
import frontend.PageController;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/4.
 */
public class Login extends InterativeForm {
    protected String username;
    protected String password;

    public Login() throws NoSuchFieldException{
        infoList.add(createDialogPair("please enter your username:", "username"));
        infoList.add(createDialogPair("please enter your password:", "password"));
    }

//    protected void execute(PageController pc){
//        UserCheck uc = UserCheck.verifyUser(username, password);
//        if (uc == UserCheck.VALID){
//            System.out.println("Successful to login.");
//            pc.changeCurrentPage(Page.USERMENU);
//            pc.setUser(new User(username));
//        }else{
//            System.out.println("Unsuccessful to login. " + uc.getMessage());
//        }
//    }

    protected void execute(PageController pc){
        try{
            CheckResult result = new ValidUser(username, password).check();
            if (result.isValid()) {
                System.out.println("Successful to login.");
                pc.changeCurrentPage(Page.USERMENU);
            }else{
                System.out.println("Unsuccessful to login. " + result.getMessage());
            }
            pc.setUser(new User(username));
        }catch (SQLException e) {
            System.out.println("Unsuccessful to login. SQLException occurs.");
            System.err.println("Error message as follows:");
            System.err.println(e.getMessage());
        }
    }

//    protected boolean getInfo(){
//        try {
//            System.out.println("please enter your username:");
//            username = Input.getLine();
//            try {
//                System.out.println("please enter your password:");
//                password = Input.getLine();
//            } catch (Exception e){
//                System.out.println("Unable to read your password, please try again.");
//                return false;
//            }
//        } catch (Exception e) {
//            System.out.println("Unable to read your username. Please try again.");
//            return false;
//        }
//        return true;
//    }
}
