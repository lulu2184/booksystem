package backend.User;

/**
 * Created by LU on 15/5/6.
 */
public enum UserInfoVerify {
    VALID{
        boolean violate(){
            return true;
        }
    },
    INCORRECT_USERNAME_FORMAT{
        boolean violate() {
            for (int i = 0; i < this.username.length(); i++){
                char c = this.username.charAt(i);
                if (!Character.isDigit(c) && !Character.isLetter(c)){
                    return true;
                }
            }
            return false;
        }
    },
    USERNAME_TOO_SHORT{
        boolean violate(){
            return this.username.length() < shortestName;
        }
    },
    USERNAME_TOO_LONG{
        boolean violate(){
            return this.username.length() > longestName;
        }
    },
    INCORRECT_PASSWORD_FORMAT{
        boolean violate(){
            for (int i = 0; i < this.password.length(); ++i){
                char c = this.username.charAt(i);
                if (!Character.isDigit(c) && !Character.isLetter(c)){
                    return true;
                }
            }
            return false;
        }
    },
    PASSWORD_TOO_SHORT{
        boolean violate(){
            return this.password.length() < shortestPassword;
        }
    },
    PASSWORD_TOO_LONG{
        boolean violate(){
            return this.password.length() > longestPassword;
        }
    };

    private static int shortestName = 5;
    private static int longestName = 20;
    private static int shortestPassword = 6;
    private static int longestPassword = 15;
    private String username;
    private String password;
    private String fullname;
    private int age;
    private String address;
    private String phone;

    abstract boolean violate();

    public boolean verify(String username, String password, String fullname, int age, String address, String phone){
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.age = age;
        this.address = address;
        this.phone = phone;
        for (UserInfoVerify V : UserInfoVerify.values()){
            if (V.violate()){
                return false;
            }
        }
        return true;
    }
}
