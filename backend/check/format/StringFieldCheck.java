package backend.check.format;

import backend.check.format.unit.StringContentChecker;
import backend.check.format.unit.StringLengthChecker;
import backend.check.CheckResult;

/**
 * Created by LU on 15/5/11.
 */
public class StringFieldCheck {
    protected String str;
    protected String field_name;
    protected StringContentChecker textChecker;
    protected int long_limit;
    protected int short_limit;

    public StringFieldCheck(String str, String field_name,int short_limit, int long_limit, StringContentChecker textChecker){
        this.str = str;
        this.field_name = field_name;
        this.long_limit = long_limit;
        this.short_limit = short_limit;
        this.textChecker = textChecker;
    }

    public CheckResult check(){
        if (!StringLengthChecker.check(str, short_limit, long_limit)){
            return new CheckResult(false,"The length of " + field_name + " is not between "
                                        + Integer.toString(short_limit) + " and " + Integer.toString(long_limit));
        }
        if (textChecker != null && !textChecker.check(str)){
            return createInvalidContentResult(textChecker.getMessage());
        }
        return new CheckResult(true,"");
    }

    protected CheckResult createInvalidContentResult(String limit){
        return new CheckResult(false, "All characters in " + field_name + " should be " + limit + ".");
    }
}
