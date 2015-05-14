package backend.check.format;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by LU on 15/5/14.
 */
public class DuplicateChecker {

    public static boolean check(Object[] obj_array){
        Set<Object> s = new HashSet<Object>();
        for(Object obj : obj_array){
            if (!s.add(obj)){
                return false;
            }
        }
        return true;
    }
}
