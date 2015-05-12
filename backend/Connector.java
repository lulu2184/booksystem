package backend;

import java.sql.*;

/**
 * Created by LU on 15/5/3.
 */
public class Connector {
    private static Connection con;
    private static Statement stmt;

    private static Connector ourInstance = null;

    public static Connector getInstance() throws Exception{
        if (ourInstance == null) {
            ourInstance = new Connector();
        }
        return ourInstance;
    }

    private Connector() throws Exception {
            try{
                String userName = "fudanu30";
                String password = "nrkgn719";
                String url = "jdbc:mysql://10.141.208.26/fudandbd30";
                Class.forName ("com.mysql.jdbc.Driver").newInstance ();
                con = DriverManager.getConnection(url, userName, password);
                stmt = con.createStatement();
            } catch(Exception e) {
                System.err.println("Unable to open mysql jdbc connection. The error is as follows,\n");
                System.err.println(e.getMessage());
                e.printStackTrace();
                throw(e);
            }
    }

    public static void ExecuteInsertion(String insertion) throws SQLException{
        stmt.executeUpdate(insertion);
    }

    public static ResultSet ExecuteQuery(String query) throws SQLException{
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }

    public static void close() throws SQLException{
        if (ourInstance == null) return;
        try{
            getInstance().con.close();
        }catch (Exception e){

        }
    }

    public static ResultSet selectStatement(String column, String from, String where)throws SQLException{
        return ExecuteQuery("SELECT " + column + " FROM " + from + " WHERE " + where + ";");
    }

    public static void insertStatement(String table, String column, String values) throws SQLException{
        ExecuteQuery("INSERT INTO " + table + "(" + column + ") VALUES(" + values +");");
    }
}
