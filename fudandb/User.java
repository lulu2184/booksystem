package fudandb;

import java.sql.*;

/**
 * Created by LU on 15/4/29.
 */
public class User {

    public User()
    {

    }

    public Boolean IsLegalNewUser(String username, Statement stmt)
    {
        return false;
    }

    public Boolean IsLegalPassword(String password, Statement stmt)
    {
        return false;
    }

    public Boolean UserCheck(String username, String password, Statement stmt)
    {
        return false;
    }

    public void CreateNewUser(String username, String password, Statement stmt)
    {

    }

}
