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
        CheckResult result = check();
        if (result.isValid()){
            Connector.ExecuteInsertion(getSQL());
            sessionUpdate();
            return CheckResult.createSuccess();
        }else {
            return result;
        }
    }

    abstract protected CheckResult check();
    protected void sessionUpdate(){};
    abstract protected String getSQL();
}
