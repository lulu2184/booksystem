package backend.query;

import backend.check.CheckResult;
import backend.check.format.unit.DigitChecker;

import java.util.Calendar;

/**
 * Created by LU on 15/5/14.
 */
abstract public class QueryForSemester extends Query{
    protected String year;
    protected String semester;
    protected String begin_date;
    protected String end_date;

    public QueryForSemester(String year, String semester){
        this.year = year;
        this.semester = semester;
    }

    protected boolean check(){
        if (!semester.equals("first") && !semester.equals("second")){
            result.setUnvalid("The semester should be \"first\" or \"second\".");
            return false;
        }
        if (!new DigitChecker().check(year) || year.length() != 4){
            result.setUnvalid("Not a valid year format.");
            return false;
        }
        return true;
    }

    protected void getBeginAndEndDate(){
        if (semester.equals("first")){
            begin_date = "-01-01";
            end_date = "-06-30";
        }else{
            begin_date = "-07-01";
            end_date = "-12-31";
        }
        begin_date = year + begin_date;
        end_date = year + end_date;
    }

    abstract protected void generateSQL();


    protected void getSQL(){
        getBeginAndEndDate();
        generateSQL();
    }

}
