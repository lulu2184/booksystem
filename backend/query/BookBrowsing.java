package backend.query;

import java.util.List;

/**
 * Created by LU on 15/5/16.
 */
public class BookBrowsing extends Query{
    private List<List<String>> query;
    private static final String[] field_name = {"ISBN", "title", "format", "subject", "pname", "publish year"};

    public BookBrowsing(List<List<String>> query){
        this.query = query;
        result.setFieldsName(field_name);
        column_name = new String[]{"ISBN", "title", "format", "subject", "pname", "publish_year"};
    }

    protected void getSQL(){
        sql = "";
        boolean outer_flag = false;
        for (List<String> product : query) {
            if (outer_flag) sql += "OR";
            else outer_flag = true;
            sql += " (";
            boolean flag = false;
            for (String condition : product) {
                if (flag) sql += " AND ";
                else flag = true;
                sql += condition;
            }
            sql += ")";
        }
        sql = "SELECT DISTINCT * FROM Book B, AuthorOf A "
                + "WHERE B.ISBN = A.ISBN AND " + sql + ";";
    }

    protected boolean check(){
        return true;
    }

}
