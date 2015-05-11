package backend.check.format.field;

import backend.check.format.unit.TextChecker;
import backend.check.CheckResult;

/**
 * Created by LU on 15/5/11.
 */
public class UsernameCheck extends  StringFieldCheck{

    public UsernameCheck(String _str){
        str = _str;
        field_name = "username";
        long_limit = 20;
        short_limit = 4;
        this.textChecker = new TextChecker();
    }
}
