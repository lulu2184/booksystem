package backend.update;

import backend.Connector;
import backend.check.CheckResult;
import backend.check.format.FormatChecker;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/12.
 */
abstract public class Update {
    public Update(){

    }

    public CheckResult actions()throws SQLException{
        CheckResult result = formatCheck();
        if (result.isValid()){
            result = contentCheck();
            if (result.isValid()) {
                Connector.ExecuteInsertion(getSQL());
                sessionUpdate();
            }
        }
        return result;
    }

    abstract protected CheckResult formatCheck();
    abstract protected CheckResult contentCheck() throws SQLException;
    protected void sessionUpdate(){};
    abstract protected String getSQL() throws SQLException;
}
