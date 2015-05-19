package backend.info;


import backend.check.CheckResult;
import backend.check.format.StringFieldCheck;
import backend.check.format.unit.TextChecker;

/**
 * Created by LU on 15/5/12.
 */
public class BookInfo {
    public String ISBN;
    public String title;
    public Integer inum;
    public double price;
    public String format;
    public String subject;
    public String pname;
    public String[] author;
    public Integer publish_year;

    private final static int shortest_ISBN = 4;
    private final static int longest_ISBN = 40;
    private final static int shortest_title = 0;
    private final static int longest_title = 100;
    private final static int shortest_format = 4;
    private final static int longest_format = 40;
    private final static int shortest_subject = 0;
    private final static int longest_subject = 40;
    private final static int shortest_pname = 4;
    private final static int longest_pname = 40;

    public BookInfo(String ISBN, String title, Integer inum, double price, String format, String subject, String pname, Integer publish_year, String[] author){
        this.ISBN = ISBN;
        this.title = title;
        this.inum = inum;
        this.price = price;
        this.format = format;
        this.subject = subject;
        this.pname = pname;
        this.publish_year = publish_year;
        this.author = author;
    }

    public String getInsertFormat(){
        String title = this.title.replaceAll("'", "''");
        String format = this.format.replaceAll("'", "''");
        String subject = this.subject.replaceAll("'", "''");
        String pname = this.pname.replaceAll("'", "''");
        return "'" + ISBN + "', '" + title + "', " + inum.toString() + ", " + Double.toString(price) + ", '" + format + "', '" + subject
                + "', '" + pname + "', " + publish_year.toString();
    }

    public static String getColumnsFormat(){
        return "ISBN, title, inum, price, format, subject, pname, publish_year";
    }

    public CheckResult check(){
        CheckResult result = new StringFieldCheck(ISBN, "ISBN", shortest_ISBN, longest_ISBN, new TextChecker()).check();
        if (!result.isValid()){
            return result;
        }
        if (title.length() < shortest_title || title.length() > longest_title){
            return result;
        }
        result = new StringFieldCheck(format, "format", shortest_format, longest_format, null).check();
        if (!result.isValid()){
            return result;
        }
        result = new StringFieldCheck(subject, "subject", shortest_subject, longest_subject, null).check();
        if (!result.isValid()){
            return result;
        }
        if (price < 0) {
            return CheckResult.createFail("price should be a positive number.");
        }
        if (inum < 0){
            return CheckResult.createFail("number of the book should be a non-negitive number.");
        }
        if (publish_year < 1900){
            return CheckResult.createFail("publish year should larger than 1900.");
        }
        result = new StringFieldCheck(pname, "publisher name", shortest_pname, longest_pname, null).check();
        return result;
    }
}
