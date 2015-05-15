package frontend.functionality;

import backend.query.PopPublisherInSemester;
import backend.query.QueryResult;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/15.
 */
public class PopPublisher extends ListQuery{
    public String year;
    public String semester;

    public PopPublisher(){
        action_name = "Get Popular Publisher In Semester";
        item_name = "Publisher";
    }

    protected void infoListInitialize() throws NoSuchFieldException{
        infoList.add(createDialogPair("please enter the year you want to check:", "year"));
        infoList.add(createDialogPair("please enter the semester of this year you want to check:(enter first or second)", "semester"));
    }

    protected QueryResult getResult() throws SQLException{
        return new PopPublisherInSemester(year, semester).query();
    }
}
