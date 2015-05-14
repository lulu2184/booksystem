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
