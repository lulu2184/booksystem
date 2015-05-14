package backend.session;

/**
 * Created by LU on 15/5/14.
 */
public class BookInOrder {
    private static String book = null;

    public static void setBook(String ISBN){
        book = ISBN;
    }

    public static String getCurrentBook(){
        return book;
    }

    public static void bookFinish(){
        book = null;
    }
}
