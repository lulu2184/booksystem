package frontend.functionality;

import frontend.Input;
import frontend.PageController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

/**
 * Created by LU on 15/5/4.
 */
abstract class Functional {
    ArrayList<DialogPair> infoList = new ArrayList<DialogPair>();

    public Functional(){

    }

    protected abstract void execute(PageController pc);

    protected void getInfo() throws IOException, NumberFormatException, IllegalAccessException{
        for (DialogPair d : infoList){
            d.printDialog();
            String info = Input.getLine();
            if (d.attribute.getType() == Integer.class){
                Integer number = Integer.parseInt(info);
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
