package backend.check.format.unit;

/**
 * Created by LU on 15/5/11.
 */
public class StringLengthChecker {
    public static boolean check(String str, int left_boundary, int right_boundary){
        return str.length() >= left_boundary && str.length() <=right_boundary;
    }
}
