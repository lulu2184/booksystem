package backend.check.format;

import backend.check.format.field.*;
import backend.check.CheckResult;
import backend.info.UserInfo;

/**
 * Created by LU on 15/5/11.
 */
public class ValidNewUser extends FormatChecker{

    public static CheckResult check(UserInfo info){
        CheckResult result = new UsernameCheck(info.username).check();
        if (!result.isValid()){
            return result;
        }
        result = new PasswordCheck(info.password).check();
        if (!result.isValid()){
            return result;
        }
        result = new FullnameCheck(info.fullname).check();
        if (!result.isValid()){
            return result;
        }
        if (info.age < 0){
            return new CheckResult(false, "Age should be a positive integer.");
        }
        result = new AddressCheck(info.address).check();
        if (!result.isValid()){
            return result;
        }
        result = new PhoneCheck(info.phone).check();
        return result;
    }
}
