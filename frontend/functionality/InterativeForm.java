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

    protected void successUpdate(PageController pc){};

    abstract protected void execute(PageController pc);

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
            }else if (d.attribute.getType() == long.class){
                long number = Long.parseLong(info);
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
