package backend.User;

/**
 * Created by LU on 15/5/6.
 */
public enum UserInfoVerify {
    VALID{
        boolean violate(UserInfo info){
            return false;
        }
    },
    INCORRECT_USERNAME_FORMAT{
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
    USERNAME_TOO_SHORT{
        boolean violate(UserInfo info){
            return info.username.length() < shortestName;
        }
    },
    USERNAME_TOO_LONG{
        boolean violate(UserInfo info){
            return info.username.length() > longestName;
        }
    },
    INCORRECT_PASSWORD_FORMAT{
        boolean violate(UserInfo info){
            for (int i = 0; i < info.password.length(); ++i){
                char c = info.username.charAt(i);
                if (!Character.isDigit(c) && !Character.isLetter(c)){
                    return true;
                }
            }
            return false;
        }
    },
    PASSWORD_TOO_SHORT{
        boolean violate(UserInfo info){
            return info.password.length() < shortestPassword;
        }
    },
    PASSWORD_TOO_LONG{
        boolean violate(UserInfo info){
            return info.password.length() > longestPassword;
        }
    };

    private static int shortestName = 5;
    private static int longestName = 20;
    private static int shortestPassword = 6;
    private static int longestPassword = 15;

    abstract boolean violate(UserInfo info);

    public UserInfoVerify verify(UserInfo info){
        for (UserInfoVerify V : UserInfoVerify.values()){
            if (V.violate(info)){
                return V;
            }
        }
        return VALID;
    }
}
