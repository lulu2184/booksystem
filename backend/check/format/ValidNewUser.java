package backend.check.format;

import backend.check.CheckResult;
import backend.check.format.unit.DigitChecker;
import backend.check.format.unit.TextChecker;
import backend.info.UserInfo;

/**
 * Created by LU on 15/5/11.
 */
public class ValidNewUser extends FormatChecker{
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


    public static CheckResult check(UserInfo info){
//        CheckResult result = new UsernameCheck(info.username).check();
        CheckResult result = new StringFieldCheck(info.username, "username", shortest_username, longest_username, null).check();
        if (!result.isValid()){
            return result;
        }
//        result = new PasswordCheck(info.password).check();
        result = new StringFieldCheck(info.password, "password", shortest_password, longest_password, new TextChecker()).check();
        if (!result.isValid()){
            return result;
        }
//        result = new FullnameCheck(info.fullname).check();
        result = new StringFieldCheck(info.fullname, "fullname", shortest_fullname, longest_fullname, null).check();
        if (!result.isValid()){
            return result;
        }
        if (info.age < 0){
            return new CheckResult(false, "Age should be a positive integer.");
        }
//        result = new AddressCheck(info.address).check();
        result = new StringFieldCheck(info.address, "address", shortest_address, longest_address, null).check();
        if (!result.isValid()){
            return result;
        }
//        result = new PhoneCheck(info.phone).check();
        result = new StringFieldCheck(info.phone, "phone", shortest_phone, longest_phone, new DigitChecker()).check();
        return result;
    }
}
