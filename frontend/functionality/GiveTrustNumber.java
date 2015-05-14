package frontend.functionality;

import backend.check.CheckResult;
import backend.update.DeclareUser;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/13.
 */
public class GiveTrustNumber extends Update{
    public String username;
    public Integer trust_num;

    public GiveTrustNumber() {
        action_name = "Give Trust Number To User";
    }

    protected void infoListInitialize() throws NoSuchFieldException{
        infoList.add(createDialogPair("please enter the user you want to give trust number to:", "username"));
        infoList.add(createDialogPair("if you trust this user, please enter 1, otherwise, enter 0:", "trust_num"));
    }

    protected CheckResult actions() throws SQLException{
        return new DeclareUser(username, trust_num).actions();
    }
}
