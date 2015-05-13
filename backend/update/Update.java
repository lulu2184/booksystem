package backend.update;

import backend.Connector;
import backend.check.CheckResult;
import backend.check.format.FormatChecker;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by LU on 15/5/12.
 */
abstract public class Update {
    ArrayList <String> sqlList = new ArrayList<String>();

    public Update(){
    }

    public CheckResult actions()throws SQLException{
        CheckResult result = formatCheck();
        if (result.isValid()){
            result = contentCheck();
            getSQLList();
            if (result.isValid()) {
                for (String sql : sqlList) {
                    Connector.ExecuteInsertion(sql);
                    sessionUpdate();
                }
            }
        }
        return result;
    }

    abstract protected CheckResult formatCheck();
    abstract protected CheckResult contentCheck() throws SQLException;
    protected void sessionUpdate(){}
    abstract protected void getSQLList() throws SQLException;

    protected String getInsertStatement(String table, String columns, String values){
        return "INSERT INTO " + table + "(" + columns + ") VALUES(" + values +");";
    }

    protected String getUpdateStatement(String table, String update, String condition){
        return "UPDATE " + table + " SET " + update + " WHERE " + condition + ";";
    }

    protected String addQuotes(String str){
        return "'" + str + "'";
    }
}
