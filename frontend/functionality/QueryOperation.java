package frontend.functionality;

import backend.check.CheckResult;
import backend.query.QueryResult;
import frontend.PageController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.List;

/**
 * Created by LU on 15/5/14.
 */
abstract public class QueryOperation extends InterativeForm{

    public QueryOperation(){

    }


    private void Output(QueryResult result){
        ListIterator <List<String>> row_it = result.result.listIterator();
        List<String> row = null;
        while (row_it.hasNext()){
            row = row_it.next();
            ListIterator <String> field_it = result.fields_name.listIterator();
            ListIterator <String> value_it = row.listIterator();
            while (field_it.hasNext() && value_it.hasNext()) {
                System.out.println(field_it.next() + " :    " + value_it.next());
            }
        }
    }

    abstract QueryResult getResult() throws SQLException;

    protected void execute(PageController pc){
        try{
            QueryResult result = getResult();
            if (result.isValid()){
                System.out.println("Successful to " + action_name + ".");
                Output(result);
            }else{
                System.out.println("Unsuccessful to " + action_name + ". " + result.getMessage());
            }
        }catch (SQLException e){
            System.out.println("Unsuccessful to " + action_name + ". SQLException occurs.");
            System.err.println("Error message as follows:");
            System.err.println(e.getMessage());
        }
    }
}
