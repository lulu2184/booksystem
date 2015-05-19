package frontend.functionality;

import backend.check.CheckResult;
import frontend.PageController;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/14.
 */
abstract public class Update extends InterativeForm{

    protected void execute(PageController pc){
        try{
            CheckResult result = actions();
            if (result.isValid()){
                System.out.println("Successful to " + action_name.toLowerCase() + ".");
                successActions(pc);
            }else{
                System.out.println("Unsuccessful to " + action_name.toLowerCase() + ". " + result.getMessage());
            }
        }catch (SQLException e){
            System.out.println("Unsuccessful to " + action_name.toLowerCase() + ". SQLException occurs.");
            System.err.println("Error message as follows:");
            System.err.println(e.getMessage());
        }
    };

    abstract protected CheckResult actions() throws SQLException;
}
