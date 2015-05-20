package backend.update;

import backend.check.CheckResult;
import backend.check.content.ExistingCheck;
import backend.session.User;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/13.
 */
public class DeclareUser extends Update{
    private String username;
    private Integer trust_num;

    public DeclareUser(String username, Integer trust_num){
        this.username = username.replaceAll("'", "''");
        this.trust_num = trust_num;
    }

    protected CheckResult formatCheck(){
        if (trust_num < 0 || trust_num > 1){
            return CheckResult.createFail("You should enter 0 or 1 for the trust number.");
        }
        return CheckResult.createSuccess();
    }

    protected CheckResult contentCheck() throws SQLException{
        if (ExistingCheck.checkPair("Declares", "declare_username", addQuotes(User.getUsername().replaceAll("'", "''")), "declared_username", addQuotes(username))){
            return CheckResult.createFail("You have already give trust number to this user.");
        }
        if (!ExistingCheck.check("User", "username", username)){
            return CheckResult.createFail("This user not exists.");
        }
        return CheckResult.createSuccess();
    }

    protected void getSQLList(){
        String sql = getInsertStatement("Declares", "declare_username, declared_username, trust_num", addQuotes(User.getUsername().replaceAll("'", "''")) + ", " + addQuotes(username) + ", " + trust_num.toString());
        sqlList.add(sql);
    }
}
