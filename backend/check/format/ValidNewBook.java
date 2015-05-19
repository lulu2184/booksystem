package backend.check.format;

import backend.check.CheckResult;
import backend.check.format.field.*;
import backend.check.format.unit.LetterChecker;
import backend.check.format.unit.TextChecker;
import backend.info.BookInfo;
import backend.info.UserInfo;

/**
 * Created by LU on 15/5/12.
 */
public class ValidNewBook extends FormatChecker{
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

    public static CheckResult check(BookInfo info){
        CheckResult result = new StringFieldCheck(info.ISBN, "ISBN", shortest_ISBN, longest_ISBN, new TextChecker()).check();
        if (!result.isValid()){
            return result;
        }
        if (info.title.length() < shortest_title || info.title.length() > longest_title){
            return result;
        }
        result = new StringFieldCheck(info.format, "format", shortest_format, longest_format, null).check();
        if (!result.isValid()){
            return result;
        }
        result = new StringFieldCheck(info.subject, "subject", shortest_subject, longest_subject, null).check();
        if (!result.isValid()){
            return result;
        }
        if (info.price < 0) {
            return CheckResult.createFail("price should be a positive number.");
        }
        if (info.inum < 0){
            return CheckResult.createFail("number of the book should be a non-negitive number.");
        }
        if (info.publish_year < 1900){
            return CheckResult.createFail("publish year should larger than 1900.");
        }
        result = new StringFieldCheck(info.pname, "publisher name", shortest_pname, longest_pname, null).check();
        return result;
    }
}
