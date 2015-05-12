package backend.update;

import backend.check.CheckResult;
import backend.check.format.ValidNewUser;
import backend.info.UserInfo;

/**
 * Created by LU on 15/5/12.
 */
public class Register {
    public Register(){

    }

    static CheckResult newUser(UserInfo info){
        CheckResult result = ValidNewUser.check(info);
        if (!result.isValid()){
            return result;
        }
        
    }
}
