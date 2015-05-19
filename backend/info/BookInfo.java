package backend.info;



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

    public BookInfo(String ISBN, String title, Integer inum, double price, String format, String subject, String pname, Integer publish_year, String[] author){
        this.ISBN = ISBN;
        this.title = title;
        this.title = this.title.replaceAll("'", "''");
        this.inum = inum;
        this.price = price;
        this.format = format;
        this.format = this.format.replaceAll("'", "''");
        this.subject = subject;
        this.subject = this.subject.replaceAll("'", "''");
        this.pname = pname;
        this.pname = this.pname.replaceAll("'", "''");
        this.publish_year = publish_year;
        this.author = author;
        for (String auth : author){
            auth = auth.replaceAll("'", "''");
        }
    }

    public String getInsertFormat(){
        return "'" + ISBN + "', '" + title + "', " + inum.toString() + ", " + Double.toString(price) + ", '" + format + "', '" + subject
                + "', '" + pname + "', " + publish_year.toString();
    }

    public static String getColumnsFormat(){
        return "ISBN, title, inum, price, format, subject, pname, publish_year";
    }
}
