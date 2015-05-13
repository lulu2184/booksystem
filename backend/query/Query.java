package backend.query;

import backend.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by LU on 15/5/13.
 */
abstract public class Query {
    protected QueryResult result;
    protected String sql;
    protected String[] column_name;
    protected String table_name;
    protected String where_clause;
    protected String[] groupby_clause = null;
    protected String having_clause = null;
    protected String order_clause = null;


    public Query(){

    }

    private static String connected(String[] str_array){
        String result = "";
        boolean flag = false;
        for (String str : str_array){
            if (flag){
                result = result + ", ";
            }else{
                flag = true;
            }
            result = result + str;
        }
        return result;
    }

    private void getSQL(){
        sql = "SELECT " + connected(column_name);
        sql += " FROM " + table_name + " WHERE " + where_clause;
        if (groupby_clause != null){
            sql += " GROUP BY " + groupby_clause;
        }
        if (having_clause != null){
            sql += " HAVING " + having_clause;
        }
        if (order_clause != null){
            sql += " ORDER BY " + order_clause;
        }
        sql += ";";
    }

    public QueryResult query(){
        getSQL();
        try {
            ResultSet rs = Connector.ExecuteQuery(sql);
            result.setResult()
        } catch (SQLException e){
            System.out.println("Unsuccessful to query. SQL exception occurs.");
            System.err.println(e.getMessage());
            result.setUnvalid();
        }
        return result;
    }
}
