package frontend.functionality;

import backend.query.QueryResult;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/15.
 */
public class TrustedUser extends ListQuery{

    public Integer m;

    public TrustedUser(){
        action_name = "Get Trusted User";
        item_name = "User";
    }

    protected void infoListInitialize() throws NoSuchFieldException{
        infoList.add(createDialogPair("please enter a number m(number of results you want to get):", "m"));
    }

    protected QueryResult getResult()throws SQLException{
        return new backend.query.TrustedUser(m).query();
    }
}
