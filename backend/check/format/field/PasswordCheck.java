package backend.check.format.field;

import backend.check.CheckResult;
import backend.check.format.unit.TextChecker;

/**
 * Created by LU on 15/5/11.
 */
public class PasswordCheck extends StringFieldCheck{

    public PasswordCheck(String str){
        this.str = str;
        short_limit = 6;
        long_limit = 15;
        this.textChecker = new TextChecker();
    }
}
