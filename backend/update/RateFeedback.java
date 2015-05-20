package backend.update;

import backend.check.CheckResult;
import backend.check.content.ExistingCheck;
import backend.session.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by LU on 15/5/13.
 */
public class RateFeedback extends Update{
    private long fid;
    private Integer score;
    private String username;

    public RateFeedback(long fid, Integer score){
        this.fid = fid;
        this.score = score;
        this.username = User.getUsername().replaceAll("'", "''");
    }

    protected CheckResult formatCheck(){
        if (score < 0 || score > 2){
            return CheckResult.createFail("The numerical score should be 0, 1 or 2.");
        }
        return CheckResult.createSuccess();
    }

    protected CheckResult contentCheck() throws SQLException{
        if (!ExistingCheck.checkLong("Feedback", "fid", fid)){
            return CheckResult.createFail("Feedback not exits.");
        }
        if (ExistingCheck.checkPair("Rate", "username", addQuotes(username), "fid", Long.toString(fid))){
            return CheckResult.createFail("You have already rate for this feedback.");
        }
        if (ExistingCheck.checkPair("Feedback", "fid", Long.toString(fid), "username", addQuotes(username))){
            return CheckResult.createFail("This feedback is proposed by you. You are not allowed to rate for it.");
        }
        return CheckResult.createSuccess();
    }

    protected void getSQLList(){
        String sql = getInsertStatement("Rate", "fid, username, rate_num", Long.toString(fid) + ", " + addQuotes(username) + ", " + Integer.toString(score));
        sqlList.add(sql);
    }
}
