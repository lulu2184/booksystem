package frontend.functionality;

import backend.Connector;
import frontend.Input;
import frontend.Page;
import frontend.PageController;
import frontend.list.UserMenu;

import java.sql.ResultSet;

/**
 * Created by LU on 15/5/4.
 */
public class Login extends Functional{
    String username;
    String password;
    boolean succ_flag = false;

    protected void execute(PageController pc){
        if (!succ_flag) return;
        String query = "SELECT * FROM User U WHERE U.username = '" + username + "';";
        pc.exitCurrentPage();
        ResultSet rs;
        try {
            rs = Connector.ExecuteQuery(query);
            if (!rs.next()){
                System.out.println("Unsuccessful to login. Incorrect username.");
                return;
            }
            String std_password = rs.getString("password");
            if (password.equals(std_password)){
                System.out.println("Successful to login.");
                pc.changeCurrentPage(Page.USERMENU);
                UserMenu.login(username);
            }else{
                System.out.println("Unsuccessful to login. Incorrect password.");
                return;
            }
        }catch (Exception e){
            System.out.println("Unable to execute sql query. Unsuccessful to login.");
            e.printStackTrace();
            System.err.println(e.getMessage());
            return;
        }
    }

    protected void getInfo(){
        try {
            System.out.println("please enter your username:");
            username = Input.getLine();
            try {
                System.out.println("please enter your password:");
                password = Input.getLine();
                succ_flag = true;
            } catch (Exception e){
                System.out.println("Unable to read your password, please try again.");
                succ_flag = false;
            }
        } catch (Exception e){
            System.out.println("Unable to read your username. Please try again.");
            succ_flag = false;
        }
    }
}
