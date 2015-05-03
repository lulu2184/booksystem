package frontend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by LU on 15/5/3.
 */
public class Input {

    static private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));;

    public static String getLine() throws IOException{
        String result;
        while ((result = in.readLine()) == null && result.length() == 0) ;
        return result;
    }

    public static int getInt() throws IOException, NumberFormatException{
        String re = getLine();
        return Integer.parseInt(re);
    }
}
