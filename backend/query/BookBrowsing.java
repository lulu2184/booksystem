package backend.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LU on 15/5/16.
 */
public class BookBrowsing extends Query{
    private List<List<IntStrPair>> query;
    private int orderType;
    private static final String[] field_name = {"ISBN", "title", "format", "subject", "pname", "publish year", "score"};
    private static final String[] pattern = {"'%s' IN (SELECT aname FROM AuthorOf A WHERE A.ISBN = B.ISBN)",
                                            "pname = '%s'", "title LIKE '%%%s%%'", "subject LIKE '%%%s%%'"};

    public BookBrowsing(List<List<IntStrPair>> query, int orderType){
        this.query = query;
        this.orderType = orderType;
        column_name = new String[]{"ISBN", "title", "format", "subject", "pname", "publish_year", "score"};
        if (orderType < 3){
            field_name[6] = "average score of feedback";
        }else{
            field_name[6] = "average score of trusted users' feedback";
        }
        result.setFieldsName(field_name);
    }

    protected void getSQL(){
        sql = "(";
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
        sql += ")";
        if (orderType == 1){
            sql = "SELECT B.ISBN, title, format, subject, pname, publish_year, AVG(F.score) as score FROM Book B, Feedback F "
                    + "WHERE B.ISBN = F.ISBN AND " + sql +" "
                    + "GROUP BY B.ISBN, title, format, subject, pname, publish_year "
                    + "ORDER BY publish_year DESC;";
        }else if (orderType == 2){
            sql = "SELECT B.ISBN, title, format, subject, pname, publish_year, AVG(F.score) as score FROM Book B, Feedback F "
                    + "WHERE B.ISBN = F.ISBN AND " + sql +" "
                    + "GROUP BY B.ISBN, title, format, subject, pname, publish_year "
                    + "ORDER BY score DESC;";
        }else{
            sql = "SELECT DISTINCT B.ISBN, title, format, subject, pname, publish_year, AVG(F.score) as score " +
                    "FROM Book B, Feedback F, (SELECT declared_username as username FROM Declares D " +
                                                "GROUP BY declared_username HAVING SUM(trust_num)-SUM(1-trust_num) > 0) AS TU " +
                    "WHERE B.ISBN = F.ISBN AND F.username = TU.username AND " + sql + " " +
                    "GROUP BY B.ISBN, title, format, subject, pname, publish_year " +
                    "ORDER BY score DESC;";
        }
    }

    protected boolean check(){
        return true;
    }

}
