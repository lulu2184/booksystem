package backend.User;

/**
 * Created by LU on 15/5/6.
 */
public class UserInfo {

    public String username;
    public String password;
    public String fullname;
    public Integer age;
    public String address;
    public String phone;

    public UserInfo(){

    }

    public UserInfo(String _username, String _password, String _fullname, Integer _age, String _addr, String _phone){
        username = _username;
        password = _password;
        fullname = _fullname;
        age = _age;
        address = _addr;
        phone = _phone;
    }

}
