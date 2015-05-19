package backend.info;

import backend.check.CheckResult;
import backend.check.format.StringFieldCheck;
import backend.check.format.unit.DigitChecker;
import backend.check.format.unit.TextChecker;

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

    private static final int shortest_username = 4;
    private static final int longest_username = 20;
    private static final int shortest_password = 6;
    private static final int longest_password = 15;
    private static final int shortest_phone = 5;
    private static final int longest_phone = 15;
    private static final int shortest_fullname = 4;
    private static final int longest_fullname = 20;
    private static final int shortest_address = 4;
    private static final int longest_address = 100;

    public UserInfo(String _username, String _password, String _fullname, Integer _age, String _addr, String _phone){
        username = _username;
        password = _password;
        fullname = _fullname;
        age = _age;
        address = _addr;
        phone = _phone;
    }

    public String getInsertFormat(){
        String username = this.username.replaceAll("'", "''");
        String fullname = this.fullname.replaceAll("'", "''");
        String address = this.address.replaceAll("'", "''");
        return "'" + username + "', '" + password + "', '" + fullname + "', " + age.toString() + ", '" + address + "', '" + phone + "'";
    }


    public CheckResult check(){
        CheckResult result = new StringFieldCheck(username, "username", shortest_username, longest_username, null).check();
        if (!result.isValid()){
            return result;
        }
        result = new StringFieldCheck(password, "password", shortest_password, longest_password, new TextChecker()).check();
        if (!result.isValid()){
            return result;
        }
        result = new StringFieldCheck(fullname, "fullname", shortest_fullname, longest_fullname, null).check();
        if (!result.isValid()){
            return result;
        }
        if (age < 0){
            return new CheckResult(false, "Age should be a positive integer.");
        }
        result = new StringFieldCheck(address, "address", shortest_address, longest_address, null).check();
        if (!result.isValid()){
            return result;
        }
        result = new StringFieldCheck(phone, "phone", shortest_phone, longest_phone, new DigitChecker()).check();
        return result;
    }
}
