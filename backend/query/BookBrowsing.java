package backend.query;

import java.util.List;

/**
 * Created by LU on 15/5/16.
 */
public class BookBrowsing extends Query{
    private List<List<IntStrPair>> query;
    private int orderType;
    private static final String[] field_name = {"ISBN", "title", "format", "subject", "pname", "publish year"};
    private static final String[] pattern = {"'%s' IN (SELECT aname FROM AuthorOf A WHERE A.ISBN = B.ISBN)",
                                            "pname = '%s'", "title LIKE '%%%s%%'", "subject LIKE '%%%s%%'"};

    public BookBrowsing(List<List<IntStrPair>> query, int orderType){
        this.query = query;
        this.orderType = orderType;
        result.setFieldsName(field_name);
        column_name = new String[]{"ISBN", "title", "format", "subject", "pname", "publish_year"};
    }

    protected void getSQL(){
        sql = "";
        boolean outer_flag = false;
        for (List<IntStrPair> product : query) {
            if (outer_flag) sql += "OR";
            else outer_flag = true;
            sql += " (";
            boolean flag = false;
            for (IntStrPair condition : product) {
                if (flag) sql += " AND ";
                else flag = true;
                sql += String.format(pattern[condition.x], condition.str);
            }
            sql += ")";
        }
        sql = "SELECT DISTINCT * FROM Book B, Feedback F, Declare D "
                + "WHERE B.ISBN = F.ISBN AND F.username = D.declar " + sql + ";";
    }

    protected boolean check(){
        return true;
    }

}
