package frontend.functionality;

import backend.query.PopBookInSemester;
import backend.query.QueryResult;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/14.
 */
public class PopBook extends ListQuery{
    public String year;
    public String semester;

    public PopBook(){
        item_name = "book";
        action_name = "Get Popular Books In Semester";
    }

    protected void infoListInitialize()throws NoSuchFieldException{
        infoList.add(createDialogPair("please enter the year you want to check:", "year"));
        infoList.add(createDialogPair("please enter the semester of this year you want to check:(enter first or second)", "semester"));
    }

    protected QueryResult getResult() throws SQLException{
        return new PopBookInSemester(year, semester).query();
    }

}
