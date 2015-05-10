package frontend.functionality;

import java.lang.reflect.Field;

/**
 * Created by LU on 15/5/10.
 */
public class DialogPair {

    String sentence;
    Field attribute;

    public DialogPair(String _sentence, Field _attribute){
        sentence = _sentence;
        attribute = _attribute;
    }

    public void printDialog(){
        System.out.println(sentence);
    }
}
