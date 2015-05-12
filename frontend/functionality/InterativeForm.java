package frontend.functionality;

import backend.check.CheckResult;
import backend.check.content.ExistingCheck;
import frontend.Input;
import frontend.PageController;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

/**
 * Created by LU on 15/5/4.
 */
abstract class InterativeForm {
    ArrayList<DialogPair> infoList = new ArrayList<DialogPair>();
    protected String action_name;

    public InterativeForm(){

    }

    protected DialogPair createDialogPair(String info, String fieldName) throws NoSuchFieldException{
        return new DialogPair(info, this.getClass().getField(fieldName));
    }

    abstract protected CheckResult actions() throws SQLException;
    protected void successUpdate(PageController pc){};

    protected void execute(PageController pc){
        try{
            CheckResult result = actions();
            if (result.isValid()){
                System.out.println("Successful to " + action_name + ".");
                successUpdate(pc);
            }else{
                System.out.println("Unsuccessful to " + action_name + ". " + result.getMessage());
            }
        }catch (SQLException e){
            System.out.println("Unsuccessful to " + action_name + ". SQLException occurs.");
            System.err.println("Error message as follows:");
            System.err.println(e.getMessage());
        }
    };

    protected void getInfo() throws IOException, NumberFormatException, IllegalAccessException{
        for (DialogPair d : infoList){
            d.printDialog();
            String info = Input.getLine();
            if (d.attribute.getType() == Integer.class){
                Integer number = Integer.parseInt(info);
                d.attribute.set(this, number);
            }else if (d.attribute.getType() == double.class){
                double number = Double.parseDouble(info);
                d.attribute.set(this, number);
            }else{
                d.attribute.set(this, info);
            }
        }
    }

    public void Do(PageController pc){
        pc.exitCurrentPage();
        try {
            getInfo();
            execute(pc);
        }catch (IOException e){
            System.err.println(e.getMessage());
            System.out.println("Unable to get input.");
        }catch (NumberFormatException e){
            System.out.println("Invalid number format.");
        }catch (IllegalAccessException e){
            System.out.println(e.getMessage());
        }
    }

}
