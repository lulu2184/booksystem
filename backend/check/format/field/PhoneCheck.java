package backend.check.format.field;

import backend.check.format.unit.DigitChecker;

/**
 * Created by LU on 15/5/12.
 */
public class PhoneCheck extends StringFieldCheck{
    public PhoneCheck(String str){
        this.str = str;
        long_limit = 15;
        short_limit = 5;
        textChecker = new DigitChecker();
    }
}
