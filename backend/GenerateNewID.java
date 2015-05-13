package backend;

import java.util.Date;

/**
 * Created by LU on 15/5/13.
 */
public class GenerateNewID {
    private final static long milis_limit = 1000L;
    private static long counter = 0;

    public static long generate(){
        Date date = new Date();
        long id = date.getTime() * milis_limit + counter;
        counter = (counter + 1) % milis_limit;
        return id;
    }
}
