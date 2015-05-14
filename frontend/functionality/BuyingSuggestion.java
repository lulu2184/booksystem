package frontend.functionality;

import backend.query.QueryResult;
import backend.session.BookInOrder;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/14.
 */
public class BuyingSuggestion extends ListQuery {
    public BuyingSuggestion(){
        item_name = "Book";
        action_name = "Buying Suggestion";
    }

    protected void infoListInitialize(){

    }

    protected QueryResult getResult() throws SQLException{
        return new backend.query.BuyingSuggestion(BookInOrder.getCurrentBook()).query();
    }
}
