package backend.check.format.field;

import backend.check.format.unit.TextChecker;
import backend.exception.formatException.FormatException;

/**
 * Created by LU on 15/5/11.
 */
public class UsernameCheck extends  StringFieldCheck{

    public UsernameCheck(String _str){
        str = _str;
        field_name = "username";
        long_limit = 20;
        short_limit = 4;
    }

    protected boolean textCheck() throws FormatException{
        if (!TextChecker.check(str)){
            throw createFormatException("letters or digits");
        }
        return true;
    }

}
