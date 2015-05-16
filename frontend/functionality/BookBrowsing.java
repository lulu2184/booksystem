package frontend.functionality;

import frontend.Input;
import frontend.PageController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LU on 15/5/16.
 */
public class BookBrowsing {
    private List<List<String>> query = new ArrayList<List<String>>();
    private static final String[] pattern = {"aname = '%s'", "pname = '%s'", "title LIKE '%%%s'", "subject LIKE '%%%s'"};

    public BookBrowsing(){

    }

    private void getConditions(int n) throws IOException{
        List<String> tmp = new ArrayList<String>();
        for (int i = 0; i < n; i ++) {
            System.out.println("Input Of Contition " + Integer.toString(i));
            if (i > 0){
                System.out.println("please enter the conjunction between condition_" + Integer.toString(i) + " and condition_" + Integer.toString(i + 1));
                System.out.println("\"and\" or \"or\" (without quotes)");
                String conjunction = Input.getLine();
                if (!conjunction.equals("and") && !conjunction.equals("or")){
                    System.out.println("Invalid format.");
                    return;
                }
                if (conjunction.equals("or")){
                    query.add(tmp);
                    tmp = new ArrayList<String>();
                }
            }
            System.out.println("please choose a kind of condition:");
            System.out.println("1. authors constraint");
            System.out.println("2. publisher constraint");
            System.out.println("3. title-word constraint");
            System.out.println("4. subject constraint");
            int c = Input.getInt();
            String str;
            if (c == 1){
                System.out.println("please enter the author name:");
            }else if (c == 2){
                System.out.println("please enter the publisher name:");
            }else if (c == 3){
                System.out.println("please enter the word in title:");
            }else if (c == 4){
                System.out.println("please enter a subject:");
            }
            str = Input.getLine();
            str = String.format(pattern[c - 1], str);
            tmp.add(str);
        }
    }

    private void printTitle(){
        System.out.println();
        System.out.println("Book Browsing");
        System.out.println("Your input wiil be regarded as:");
        System.out.println("(condition_1 and condition_2 and ... and condition_p) or .... or (condition_q and ... and condition_n)");
        System.out.println("please enter the number of conditions(n):");
    }

    protected void getInfo() throws IOException, NumberFormatException{
        String str = Input.getLine();
        int n = Integer.parseInt(str);
        getConditions(n);
    }

    private void execute(PageController pc){

    }

    public void Do(PageController pc){
        try{
            getInfo();
            execute(pc);
        }catch (IOException e){
            System.out.println("Unable to read.");
        }catch (NumberFormatException e){
            System.out.println("Invalid number format.");
        }
    }
}
