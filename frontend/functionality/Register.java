package frontend.functionality;

import backend.User.UserInfo;
import frontend.Input;
import frontend.PageController;

/**
 * Created by LU on 15/5/4.
 */
public class Register extends Functional{
    String username;
    String password;
    String fullname;
    Integer age;
    String address;
    String phone;
    UserInfo information;

    public Register(){

    }

//    public boolean getInfo(){
//        try {
//            System.out.println("please enter the username:");
//            username = Input.getLine();
//            try{
//                System.out.println("please enter the password:");
//                password = Input.getLine();
//            } catch (Exception e){
//                System.out.println("Unable to read password, please try again.");
//                return false;
//            }
//        } catch (Exception e) {
//            System.out.println("Unable to read username, please try again.");
//            return false;
//        }
//        return true;
//    }

    public void execute(PageController pc){

    }
}
