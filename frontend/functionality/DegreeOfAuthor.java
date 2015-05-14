package frontend.functionality;

import backend.check.CheckResult;
import frontend.PageController;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/14.
 */
public class DegreeOfAuthor extends InterativeForm{
    public String author1;
    public String author2;

    public DegreeOfAuthor() {
        action_name = "calculate degree of authors";
    }

    protected void infoListInitialize() throws NoSuchFieldException{
        infoList.add(createDialogPair("please enter name of an author:", "author1"));
        infoList.add(createDialogPair("please enter name of another author:", "author2"));
    }

    protected void execute(PageController pc){
        try{
            CheckResult result = new backend.query.DegreeOfAuthor(author1, author2).query();
            if (result.isValid()){
                System.out.println("Successful to " + action_name + ".");
                System.out.println("The degree of " + author1 + " and " + author2 + " is " + result.getMessage() + ".");
            }else{
                System.out.println("Unsuccessful to " + action_name + ". " + result.getMessage());
            }
        }catch (SQLException e){
            System.out.println("Unsuccessful to " + action_name + ". SQLException occurs.");
            System.err.println("Error message as follows:");
            System.err.println(e.getMessage());
        }
    };

}
