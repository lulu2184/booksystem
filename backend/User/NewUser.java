package backend.user;

import backend.Connector;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/6.
 */
public enum NewUser {
    VALID(""){
//        boolean violate(UserInfo info){
//            return false;
//        }
    },
    INCORRECT_USERNAME_FORMAT("Incorrect username format."){
        boolean violate(UserInfo info) {
            for (int i = 0; i < info.username.length(); i++){
                char c = info.username.charAt(i);
                if (!Character.isDigit(c) && !Character.isLetter(c)){
                    return true;
                }
            }
            return false;
        }
    },
    USERNAME_TOO_SHORT("Username too short."){
        boolean violate(UserInfo info){
            return info.username.length() < shortestName;
        }
    },
    USERNAME_TOO_LONG("Username too long."){
        boolean violate(UserInfo info){
            return info.username.length() > longestName;
        }
    },
    INCORRECT_PASSWORD_FORMAT("Incorrect password format."){
        boolean violate(UserInfo info){
            for (int i = 0; i < info.password.length(); ++i){
                char c = info.password.charAt(i);
                if (!Character.isDigit(c) && !Character.isLetter(c)){
                    return true;
                }
            }
            return false;
        }
    },
    PASSWORD_TOO_SHORT("Password too short."){
        boolean violate(UserInfo info){
            return info.password.length() < shortestPassword;
        }
    },
    PASSWORD_TOO_LONG("Password too long."){
        boolean violate(UserInfo info){
            return info.password.length() > longestPassword;
        }
    },
    SQL_ERROR("Error while executing sql insertion.");

    private static int shortestName = 4;
    private static int longestName = 20;
    private static int shortestPassword = 6;
    private static int longestPassword = 15;

    String message;

    NewUser(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    boolean violate(UserInfo info){
        return false;
    }

    private static NewUser insertUser(UserInfo info){
        String sqlInsertion = "INSERT INTO User(username, password, fullname, age, addr, phone) VALUES('"
                                + info.username + "', '" + info.password + "', '" + info.fullname + "', " + info.age.toString()
                                + ", '" + info.address + "', '" + info.phone + "');";
        try{
            Connector.ExecuteInsertion(sqlInsertion);
            return VALID;
        } catch (SQLException e){
            System.err.println(e.getMessage());
            return SQL_ERROR;
        }
    }

    public static NewUser createNewUser(UserInfo info){
        NewUser rs = verify(info);
        if (rs == VALID){
            return insertUser(info);
        }else return rs;
    }

    private static NewUser verify(UserInfo info){
        for (NewUser V : NewUser.values()){
            if (V.violate(info)){
                return V;
            }
        }
        return VALID;
    }
}
