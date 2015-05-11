package backend.check.format.field;

import backend.check.format.unit.StringContentChecker;
import backend.check.format.unit.StringLengthChecker;
import backend.check.CheckResult;

/**
 * Created by LU on 15/5/11.
 */
abstract public class StringFieldCheck {
    protected String str;
    protected String field_name;
    protected StringContentChecker textChecker;
    protected int long_limit;
    protected int short_limit;

    public StringFieldCheck(){

    }

    public CheckResult check(){
        if (!StringLengthChecker.check(str, short_limit, long_limit)){
            return new CheckResult(false,"The length of " + field_name + " is not between "
                                        + Integer.toString(short_limit) + " and " + Integer.toString(long_limit));
        }
        if (!textChecker.check(str)){
            return createInvalidContentResult(textChecker.getMessage());
        }
        return new CheckResult(true,"");
    }

    protected CheckResult createInvalidContentResult(String limit){
        return new CheckResult(false, "All characters in " + field_name + " should be " + limit + ".");
    }
}
