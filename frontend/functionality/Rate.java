package frontend.functionality;

import backend.check.CheckResult;
import backend.update.RateFeedback;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/13.
 */
public class Rate extends Update{
    public long fid;
    public Integer score;

    public Rate() throws NoSuchFieldException{
        action_name = "rate for a feedback";
        infoList.add(createDialogPair("please enter the ID of feedback you want to rate for:", "fid"));
        infoList.add(createDialogPair("please enter the numerical score you want to give to this feedback:", "score"));
    }

    protected CheckResult actions() throws SQLException{
        return new RateFeedback(fid, score).actions();
    }

}
