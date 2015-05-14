package frontend.functionality;

import backend.check.CheckResult;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/13.
 */
public class GiveFeedback extends Update{

    public String book;
    public Integer score;
    public String content;

    public GiveFeedback() throws NoSuchFieldException{
        action_name = "give feedback";
        infoList.add(createDialogPair("please enter the ISBN of the book you want to give feedback to:", "book"));
        infoList.add(createDialogPair("please enter the score you want to give to this book:", "score"));
        infoList.add(createDialogPair("please enter your comment to this book:", "content"));
    }

    protected CheckResult actions() throws SQLException{
        return new backend.update.GiveFeedback(book, score, content).actions();
    }
}
