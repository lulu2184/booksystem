package frontend.functionality;

import backend.query.QueryResult;
import backend.query.UsefulFeedback;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/14.
 */
public class FindUsefulFeedback extends ListQuery {
    public String book;
    public Integer number;

    public FindUsefulFeedback() {
        action_name = "Find Userful Feedback";
        item_name = "Feedback";
    }

    protected void infoListInitialize() throws NoSuchFieldException{
        infoList.add(createDialogPair("please enter the ISBN of the book you want to find useful feedback:", "book"));
        infoList.add(createDialogPair("please enter the number of feedbacks you want:", "number"));
    }

    protected QueryResult getResult() throws SQLException{
        return new UsefulFeedback(book, number).query();
    }

}
