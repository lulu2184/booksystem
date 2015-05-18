package frontend.functionality;

import backend.query.IntStrPair;
import backend.query.QueryResult;
import frontend.Input;
import frontend.PageController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by LU on 15/5/16.
 */
public class BookBrowsing {
    private List<List<IntStrPair>> query = new ArrayList<List<IntStrPair>>();
    private int orderType;

    public BookBrowsing(){

    }

    private boolean getConditions(int n) throws IOException{
        List<IntStrPair> tmp = new ArrayList<IntStrPair>();
        for (int i = 0; i < n; i ++) {
            System.out.println("Input Of Contition " + Integer.toString(i + 1));
            if (i > 0){
                System.out.println("please enter the conjunction between condition_" + Integer.toString(i) + " and condition_" + Integer.toString(i + 1));
                System.out.println("\"and\" or \"or\" (without quotes)");
                String conjunction = Input.getLine();
                if (!conjunction.equals("and") && !conjunction.equals("or")){
                    System.out.println("Invalid format.");
                    return false;
                }
                if (conjunction.equals("or")){
                    query.add(tmp);
                    tmp = new ArrayList<IntStrPair>();
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
            }else{
                System.out.println("Invalid number format.");
                return false;
            }
            str = Input.getLine();
            tmp.add(new IntStrPair(c - 1, str));
        }
        query.add(tmp);
        System.out.println();
        System.out.println("how do you like the result to be sorted:");
        System.out.println("1. order by year");
        System.out.println("2. order by the average numerical score of the feedbacks");
        System.out.println("3. order by the average numerical score of the trusted user feedbacks");
        System.out.println("please enter your choice:");
        orderType = Input.getInt();
        return true;
    }

    private void printTitle(){
        System.out.println();
        System.out.println("Book Browsing");
        System.out.println("Your input wiil be regarded as:");
        System.out.println("(condition_1 and condition_2 and ... and condition_p) or .... or (condition_q and ... and condition_n)");
        System.out.println("please enter the number of conditions(n):");
    }

    private void Output(QueryResult result){
        ListIterator<List<String>> row_it = result.result.listIterator();
        List<String> row;
        int count = 0;
        while (row_it.hasNext()){
            count++;
            System.out.println("Book" + "  " + Integer.toString(count) + ":");
            row = row_it.next();
            ListIterator <String> field_it = result.fields_name.listIterator();
            ListIterator <String> value_it = row.listIterator();
            while (field_it.hasNext() && value_it.hasNext()) {
                System.out.printf("%-30s  %s\n",field_it.next() + ":", value_it.next());
            }
            System.out.println();
        }
        if (count == 0){
            System.out.println("No books satisfies your constraints.");
        }
    }

    protected boolean getInfo() throws IOException, NumberFormatException{
        String str = Input.getLine();
        int n = Integer.parseInt(str);
        return getConditions(n);
    }

    private QueryResult execute(PageController pc) throws SQLException{
        return new backend.query.BookBrowsing(query, orderType).query();
    }

    public void Do(PageController pc){
        printTitle();
        pc.exitCurrentPage();
        try{
            if (getInfo())
                Output(execute(pc));
        }catch (IOException e){
            System.out.println("Unable to read.");
        }catch (NumberFormatException e){
            System.out.println("Invalid number format.");
        }catch (SQLException e){
            System.out.println("SQL exception occurs.");
            System.err.println(e.getMessage());
        }
    }
}
