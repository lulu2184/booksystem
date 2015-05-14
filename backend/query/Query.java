package backend.query;

import backend.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by LU on 15/5/13.
 */
abstract public class Query {
    protected QueryResult result = new QueryResult();
    protected String sql;
    protected String[] column_name;

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

    abstract void getSQL();
    abstract boolean check() throws SQLException;

//    private void getSQL(){
//        sql = "SELECT " + connected(column_name);
//        sql += " FROM " + table_name + " WHERE " + where_clause;
//        if (groupby_clause != null){
//            sql += " GROUP BY " + connected(groupby_clause);
//        }
//        if (having_clause != null){
//            sql += " HAVING " + having_clause;
//        }
//        if (order_clause != null){
//            sql += " ORDER BY " + order_clause;
//        }
//        sql += ";";
//    }

    public QueryResult query() throws SQLException{
        if (!check()){
            return result;
        }
        getSQL();
        ResultSet rs = Connector.ExecuteQuery(sql);
        result.setResult(rs, column_name);
        return result;
    }
}
