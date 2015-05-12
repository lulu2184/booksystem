package frontend.functionality;

import backend.check.CheckResult;
import backend.info.BookInfo;
import backend.update.CreateNewBook;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/12.
 */
public class InsertBook extends InterativeForm{
    public String ISBN;
    public String title;
    public Integer inum;
    public double price;
    public String format;
    public String subject;
    public String pname;
    public Integer publish_year;

    public InsertBook() throws NoSuchFieldException{
        infoList.add(createDialogPair("please enter the ISBN of the book:", "ISBN"));
        infoList.add(createDialogPair("please enter the title of the book:", "title"));
        infoList.add(createDialogPair("please enter the quantity of this book:", "inum"));
        infoList.add(createDialogPair("please enter the price of this book:", "price"));
        infoList.add(createDialogPair("please enter the format of this book:", "format"));
        infoList.add(createDialogPair("please enter the subject of this book:", "subject"));
        infoList.add(createDialogPair("please enter the publisher name of this book:", "pname"));
        infoList.add(createDialogPair("please enter the publish year of this book:", "publish_year"));
        action_name = "insert a new book";
    }

    protected CheckResult actions() throws SQLException{
        BookInfo info = new BookInfo(ISBN, title, inum, price, format, subject, pname, publish_year);
        return new CreateNewBook(info).actions();
    }
}
