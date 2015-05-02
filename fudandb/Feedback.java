package fudandb;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by LU on 15/4/30.
 */
public class Feedback {

    public Feedback(){

    }

    public ResultSet SearchUsefulFeedbackForBook(String bookname, Statement stmt){
        return null;
    }

    public void giveFeedback(String username, String ISBN, int score, String comment, Statement stmt) throws Exception{

    }

    public ResultSet feedbackOfABook(String book, Statement stmt){
        return null;
    }

    public void rateForFeedback(String username,int fid, int rate_score, Statement stmt) throws Exception{

    }
}
