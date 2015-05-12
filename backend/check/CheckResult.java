package backend.check;

/**
 * Created by LU on 15/5/11.
 */
public class CheckResult {
    private String message;
    private boolean valid;

    public CheckResult(){

    }

    public CheckResult(boolean valid, String message){
        this.message = message;
        this.valid = valid;
    }

    public String getMessage(){
        return message;
    }

    public boolean isValid(){
        return valid;
    }

    public static CheckResult createSuccess(){
        return new CheckResult(true, "");
    }
}
