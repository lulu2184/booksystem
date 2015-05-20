package backend.update;

import backend.GenerateNewID;
import backend.check.CheckResult;
import backend.check.content.ExistingCheck;
import backend.session.User;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by LU on 15/5/13.
 */
public class GiveFeedback extends Update{
    private String book;
    private Integer score;
    private String content;
    private long fid;
    private String username;
    private Date date;
    private static SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm::ss");

    public GiveFeedback(String book, Integer score, String content){
        this.book = book.replaceAll("'", "''");
        this.score = score;
        this.content = content.replaceAll("'", "''");
        this.fid = GenerateNewID.generate();
        this.username = User.getUsername().replaceAll("'", "''");
        this.date = new Date();
    }

    protected CheckResult formatCheck(){
        if (score < 0 || score > 10){
            return CheckResult.createFail("The score should between 0 and 10.");
        }
        if (content.length() > 2000){
            return CheckResult.createFail("The content is too long.");
        }
        return CheckResult.createSuccess();
    }

    protected CheckResult contentCheck() throws SQLException{
        if (!ExistingCheck.check("Book", "ISBN", book)){
            return CheckResult.createFail("The book is not exist.");
        }
        if (ExistingCheck.checkPair("Feedback", "ISBN", addQuotes(book), "username", addQuotes(username))){
            return CheckResult.createFail("You have already give a feedback to this book.");
        }
        return CheckResult.createSuccess();
    }

    protected void getSQLList(){
        String sql = getInsertStatement("Feedback", "fid, propose_date, score, ISBN, username, content",
                                    Long.toString(fid) + ", " + addQuotes(dateformat.format(date)) + ", " + Integer.toString(score)
                                    + ", " + addQuotes(book) + ", " + addQuotes(username) + ", " + addQuotes(content));
        sqlList.add(sql);
    }
}
