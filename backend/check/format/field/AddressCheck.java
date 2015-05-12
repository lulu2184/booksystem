package backend.check.format.field;

/**
 * Created by LU on 15/5/12.
 */
public class AddressCheck extends StringFieldCheck{
    public AddressCheck(String str){
        this.str = str;
        long_limit = 100;
        short_limit = 5;
        textChecker = null;
        field_name = "address";
    }
}
