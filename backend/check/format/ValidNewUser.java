package backend.check.format;

import backend.check.format.field.PasswordCheck;
import backend.check.format.field.UsernameCheck;
import backend.check.CheckResult;

/**
 * Created by LU on 15/5/11.
 */
public class ValidNewUser extends FormatChecker{

    private final static int shortestName = 4;
    private final static int longestName = 20;
    private final static int shortestPassword = 6;
    private final static int longestPassword = 15;
    private final static int shortestFullname = 4;
    private final static int longestFullname = 20;


    public static CheckResult check(String username, String password, String fullname){
        CheckResult result = new UsernameCheck(username).check();
        if (!result.isValid()){
            return result;
        }
        result = new PasswordCheck(password).check();
        if (!result.isValid()){
            return result;
        }
        result =

//        if (!StringLengthChecker.check(username, shortestName, longestName)){
//            throw new LengthOverBoundaryException("The length of username is not between "
//                                    + Integer.toString(shortestName) + " and " + Integer.toString(longestName));
//        }
//        if (!TextChecker.check(username)){
//            throw new TextFormatException("All characters in username should be letters or digits.");
//        }
//        if (!StringLengthChecker.check(password, shortestPassword, longestPassword)){
//            throw new LengthOverBoundaryException("The length of password is not between "
//                                    + Integer.toString(shortestPassword) + " and " + Integer.toString(longestPassword));
//        }
//        if (!TextChecker.check(password)){
//            throw new TextFormatException("All characters in password should be letters or digits.");
//        }
//        if ()
//        if (!LetterChecker.check(fullname)){
//            throw new TextFormatException("All characters in fullname should be letters.");
//        }
//        return true;
    }
}
