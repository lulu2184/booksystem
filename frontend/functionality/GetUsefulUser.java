package frontend.functionality;

import backend.query.QueryResult;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/15.
 */
public class GetUsefulUser extends ListQuery{
    public Integer m;

    public GetUsefulUser(){
        action_name = "Get Useful User";
        item_name = "User";
    }

    protected void infoListInitialize() throws NoSuchFieldException{
        infoList.add(createDialogPair("please please enter a number m(number of results you want to get):", "m"));
    }

    protected QueryResult getResult() throws SQLException{
        return new backend.query.UsefulUser(m).query();
    }

}
