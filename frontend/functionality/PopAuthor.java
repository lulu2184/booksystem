package frontend.functionality;

import backend.query.PopAuthorInSemester;
import backend.query.QueryResult;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/15.
 */
public class PopAuthor extends ListQuery{
    public String year;
    public String semester;

    public PopAuthor(){
        action_name = "Get Popular Author In Semester";
        item_name = "Author";
    }

    protected void infoListInitialize() throws NoSuchFieldException{
        infoList.add(createDialogPair("please enter the year you want to check:", "year"));
        infoList.add(createDialogPair("please enter the semester of this year you want to check:(enter first or second)", "semester"));
    }

    protected QueryResult getResult() throws SQLException{
        return new PopAuthorInSemester(year, semester).query();
    }
}
