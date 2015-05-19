package backend.check.format.field;

import backend.check.CheckResult;
import backend.check.format.unit.LetterChecker;

/**
 * Created by LU on 15/5/11.
 */
public class FullnameCheck extends StringFieldCheck{

    public FullnameCheck(String str){
        this.str = str;
        long_limit = 20;
        short_limit = 4;
        this.textChecker = new LetterChecker();
        field_name = "fullname";
    }

}
