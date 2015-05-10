package frontend.functionality;

import backend.User.User;
import backend.User.UserCheck;
import frontend.Input;
import frontend.Page;
import frontend.PageController;
import frontend.list.UserMenu;

import java.util.NoSuchElementException;

/**
 * Created by LU on 15/5/4.
 */
public class Login extends Functional{
    protected String username;
    protected String password;

    public Login() throws NoSuchFieldException{
        infoList.add(new DialogPair("please enter your username:", this.getClass().getDeclaredField("username")));
        infoList.add(new DialogPair("please enter your password:", this.getClass().getDeclaredField("password")));
    }

    protected void execute(PageController pc){
        UserCheck uc = UserCheck.verifyUser(username, password);
        if (uc == UserCheck.VALID){
            System.out.println("Successful to login.");
            pc.changeCurrentPage(Page.USERMENU);
            pc.setUser(new User(username));
        }else{
            System.out.println("Unsuccessful to login. " + uc.getMessage());
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
