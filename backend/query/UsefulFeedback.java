package backend.query;

/**
 * Created by LU on 15/5/13.
 */
public class UsefulFeedback extends Query{
    private String book;
    private Integer number;
    private static final String[] field_name = {"fid", "usefulness score", "user", "date", "comment"};

    public UsefulFeedback(String book, Integer number){
        this.book = book;
        this.number = number;
        result.setFieldsName(field_name);
        column_name = new String[]{"fid", "avg(score)", "username", "date", "content"};

    }

}
