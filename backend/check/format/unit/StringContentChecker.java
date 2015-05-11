package backend.check.format.unit;

/**
 * Created by LU on 15/5/11.
 */
abstract public class StringContentChecker {
    protected String message;

    public StringContentChecker(){

    }

    public String getMessage(){
        return message;
    }

    abstract public boolean check(String str);
}
