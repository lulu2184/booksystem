package backend.user;

import backend.Connector;

import java.sql.ResultSet;

/**
 * Created by LU on 15/5/4.
 */
public enum UserCheck {
    VALID("Correct username and password."),
    INCORRECT_USERNAME("Incorrect username."),
    INCORRECT_PASSWORD("Incorrect password."),
    UNABLE_TO_EXECUTE_SQL("Unable to execute sql query.");

    String message;

    UserCheck(String message){
        this.message = message;
    }

    public static UserCheck verifyUser(String username, String password){
        String query = "SELECT * FROM User U WHERE U.username = '" + username + "';";
        ResultSet rs;
        try {
            rs = Connector.ExecuteQuery(query);
            if (!rs.next()){
                return INCORRECT_USERNAME;
            }
            String std_password = rs.getString("password");
            if (password.equals(std_password)){
                return VALID;
            }else{
                return INCORRECT_PASSWORD;
            }
        }catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getMessage());
            return UNABLE_TO_EXECUTE_SQL;
        }
    }

    public String getMessage(){
        return message;
    }

}
