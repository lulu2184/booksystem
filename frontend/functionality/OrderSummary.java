package frontend.functionality;

import backend.query.QueryResult;
import backend.session.*;
import frontend.PageController;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by LU on 15/5/19.
 */
public class OrderSummary extends ListQuery{

    public OrderSummary(){
        action_name = "Order Summary";
        item_name = "book";
    }

    protected QueryResult getResult() throws SQLException{
        return new backend.query.OrderSummary().query();
    }

    protected void infoListInitialize(){

    }

    protected void finishActions(){
        backend.session.Order.finishOrder();
    }
}
