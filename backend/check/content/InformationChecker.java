package backend.check.content;

import backend.Connector;
import backend.check.CheckResult;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by LU on 15/5/11.
 */
abstract public class InformationChecker {

    protected InformationChecker() {
    }

    abstract protected String getSQLquery();

    abstract protected CheckResult Analyze(ResultSet rs) throws SQLException;

    public CheckResult check() throws SQLException{
        String sql = getSQLquery();
        ResultSet rs = Connector.ExecuteQuery(sql);
        return Analyze(rs);
    }
}
