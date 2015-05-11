package backend.check.content;

import backend.Connector;
import backend.exception.informationException.InformationException;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by LU on 15/5/11.
 */
abstract public class InformationChecker {

    protected InformationChecker() {
    }

    abstract protected String getSQLquery();

    abstract protected boolean Analyze(ResultSet rs) throws SQLException, InformationException;

    public boolean check() throws SQLException, InformationException {
        String sql = getSQLquery();
        ResultSet rs = Connector.ExecuteQuery(sql);
        return Analyze(rs);
    }
}
