package backend.check.format.unit;

/**
 * Created by LU on 15/5/11.
 */
public class TextChecker {
    public static boolean check(String str){
        for (int i = 0; i < str.length(); ++i){
            if (!(Character.isLetter(str.charAt(i)) || Character.isDigit(str.charAt(i)))){
                return false;
            }
        }
        return true;
    }
}
