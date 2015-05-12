package backend.query;

import backend.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by LU on 15/5/12.
 */
public class NumberOfBookQuery {

    public static int query(String book)throws SQLException{
        ResultSet rs = Connector.selectStatement("*", "Book", "ISBN = '" + book + "'");
        if (!rs.next()){
            return 0;
        }
        return rs.getInt("inum");
    }
}
