package frontend.functionality;

import backend.info.UserInfo;
import frontend.PageController;

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
    UserInfo information;

    public Register() throws NoSuchFieldException{
        infoList.add(createDialogPair("please enter your username;","username"));
        infoList.add(createDialogPair("please enter your password:", "password"));
        infoList.add(createDialogPair("please enter your fullname:", "fullname"));
        infoList.add(createDialogPair("please enter your age:", "age"));
        infoList.add(createDialogPair("please enter your address:", "address"));
        infoList.add(createDialogPair("please enter your phone number:", "phone"));
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
//        UserInfo info = new UserInfo(username, password, fullname, age, address, phone);
//        NewUser rs = NewUser.createNewUser(info);
//        if (rs == NewUser.VALID){
//            System.out.println("Successful to register.");
//            pc.changeCurrentPage(Page.USERMENU);
//            pc.setUser(new User(username));
//        } else{
//            System.out.println("Unsucessful to register." + rs.getMessage());
//        }
        UserInfo userinfo = new UserInfo(username, password, fullname, age, address, phone);


    }
}
