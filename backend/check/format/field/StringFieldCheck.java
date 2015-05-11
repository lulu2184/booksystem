package backend.check.format.field;

import backend.check.format.unit.StringLengthChecker;
import backend.exception.formatException.FormatException;
import backend.exception.formatException.LengthOverBoundaryException;

/**
 * Created by LU on 15/5/11.
 */
abstract public class StringFieldCheck {
    protected String str;
    protected String field_name;
    protected int long_limit;
    protected int short_limit;

    public StringFieldCheck(){

    }

    public boolean check() throws LengthOverBoundaryException, FormatException{
        if (!StringLengthChecker.check(str, short_limit, long_limit)){
            throw new LengthOverBoundaryException("The length of " + field_name + " is not between "
                                        + Integer.toString(short_limit) + " and " + Integer.toString(long_limit));
        }
        return textCheck();
    }

    abstract protected boolean textCheck() throws FormatException;

    protected FormatException createFormatException(String limit){
        return new FormatException("All characters in " + field_name + " should be " + limit + ".");
    }
}
