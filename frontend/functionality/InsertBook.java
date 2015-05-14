package frontend.functionality;

import backend.check.CheckResult;
import backend.info.BookInfo;
import backend.update.CreateNewBook;

import java.sql.SQLException;

/**
 * Created by LU on 15/5/12.
 */
public class InsertBook extends Update{
    public String ISBN;
    public String title;
    public Integer inum;
    public double price;
    public String format;
    public String subject;
    public String pname;
    public String authors;
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
        infoList.add(createDialogPair("please enter the authors of this book:(use comma or space to seperate them)", "authors"));
        action_name = "Insert New Book";
    }

    protected CheckResult actions() throws SQLException{
        String[] author_list = authors.split("(,| )");
        BookInfo info = new BookInfo(ISBN, title, inum, price, format, subject, pname, publish_year,author_list);
        return new CreateNewBook(info).actions();
    }
}
