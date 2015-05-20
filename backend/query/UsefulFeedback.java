package backend.query;

import backend.check.content.ExistingCheck;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/13.
 */
public class UsefulFeedback extends Query{
    private String book;
    private Integer number;
    private static final String[] field_name = {"fid", "usefulness score", "user", "date", "comment"};

    public UsefulFeedback(String book, Integer number){
        this.book = book.replaceAll("'", "''");
        this.number = number;
        result.setFieldsName(field_name);
        column_name = new String[]{"fid", "avg(R.rate_num)", "username", "propose_date", "content"};
    }

    protected void getSQL(){
        sql = "SELECT " + " F.fid, avg(R.rate_num), F.username, F.propose_date, F.content "
                + "FROM Rate R, Feedback F "
                + "WHERE R.fid = F.fid AND F.ISBN = '" + book + "'"
                + "GROUP BY F.fid "
                + "ORDER BY avg(R.rate_num) DESC "
                + "LIMIT " + number.toString() + ";";
    }

    protected boolean check()throws SQLException{
        if (number < 0){
            result.setUnvalid("the number N should be a positive integer.");
            return false;
        }
        if (!ExistingCheck.check("Book", "ISBN", book)){
            result.setUnvalid("not a existing book.");
            return false;
        }
        return true;
    }

}
