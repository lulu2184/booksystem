package frontend.functionality;

import backend.query.QueryResult;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by LU on 15/5/19.
 */
public class OrderSummary extends ListQuery{

    public OrderSummary(){
        action_name = "Order Summary";
    }

    protected QueryResult getResult() throws SQLException{
        return new backend.query.OrderSummary().query();
    }

    protected void infoListInitialize(){

    }
}
