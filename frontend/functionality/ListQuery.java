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
abstract public class ListQuery extends InterativeForm{
    protected String item_name;

    public ListQuery(){

    }


    private void Output(QueryResult result){
        ListIterator <List<String>> row_it = result.result.listIterator();
        List<String> row;
        int count = 0;
        while (row_it.hasNext()){
            count++;
            System.out.println(item_name + "  " + Integer.toString(count) + ":");
            row = row_it.next();
            ListIterator <String> field_it = result.fields_name.listIterator();
            ListIterator <String> value_it = row.listIterator();
            while (field_it.hasNext() && value_it.hasNext()) {
                System.out.printf("%-20s  %s\n",field_it.next() + ":", value_it.next());
            }
            System.out.println();
        }
    }

    abstract QueryResult getResult() throws SQLException;

    protected void execute(PageController pc){
        try{
            QueryResult result = getResult();
            if (result.isValid()){
                System.out.println("Successful to " + action_name.toLowerCase() + ".");
                Output(result);
            }else{
                System.out.println("Unsuccessful to " + action_name.toLowerCase() + ". " + result.getMessage());
            }
        }catch (SQLException e){
            System.out.println("Unsuccessful to " + action_name.toLowerCase() + ". SQLException occurs.");
            System.err.println("Error message as follows:");
            System.err.println(e.getMessage());
        }
    }
}
