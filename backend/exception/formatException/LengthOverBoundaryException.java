package backend.exception.formatException;

/**
 * Created by LU on 15/5/11.
 */
public class LengthOverBoundaryException extends FormatException{
    public LengthOverBoundaryException(){

    }

    public LengthOverBoundaryException(String message){
        super(message);
    }
}
