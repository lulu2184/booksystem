package frontend.functionality;

import backend.User.NewUser;
import backend.User.User;
import backend.User.UserInfo;
import frontend.Input;
import frontend.Page;
import frontend.PageController;
import frontend.list.UserMenu;

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

    public Register() throws NoSuchFieldException{
        infoList.add(new DialogPair("please enter your username;", this.getClass().getDeclaredField("username")));
        infoList.add(new DialogPair("please enter your password:", this.getClass().getDeclaredField("password")));
        infoList.add(new DialogPair("please enter your fullname:", this.getClass().getDeclaredField("fullname")));
        infoList.add(new DialogPair("please enter your age:", this.getClass().getDeclaredField("age")));
        infoList.add(new DialogPair("please enter your address:", this.getClass().getDeclaredField("address")));
        infoList.add(new DialogPair("please enter your phone number:", this.getClass().getDeclaredField("phone")));
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
        UserInfo info = new UserInfo(username, password, fullname, age, address, phone);
        NewUser rs = NewUser.createNewUser(info);
        if (rs == NewUser.VALID){
            System.out.println("Successful to register.");
            pc.changeCurrentPage(Page.USERMENU);
            pc.setUser(new User(username));
        } else{
            System.out.println("Unsucessful to register." + rs.getMessage());
        }
    }
}
