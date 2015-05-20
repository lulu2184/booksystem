package backend.query;

import backend.session.User;

/**
 * Created by LU on 15/5/14.
 */
public class BuyingSuggestion extends Query{
    private String book;
    private String username;
    private static final String[] field_name = {"ISBN", "title", "sales count"};

    public BuyingSuggestion(String book){
        this.book = book;
        this.username = User.getUsername().replaceAll("'", "''");
        result.setFieldsName(field_name);
        column_name = new String[] {"B2.ISBN","B2.title", "count"};
    }

    protected void getSQL(){
        sql = "SELECT B2.ISBN, B2.title, SUM(I2.num) as count FROM Book B1, InOrder I1, Orders O1, Book B2, InOrder I2, Orders O2 "
                + "WHERE B1.ISBN = I1.ISBN AND I1.orderid = O1.orderid AND B1.ISBN = '" + book + "' AND B2.ISBN <> B1.ISBN "
                + "AND B2.ISBN = I2.ISBN AND I2.orderid = O2.orderid AND O1.username = O2.username  AND O1.username <> '" + username + "' "
                + "GROUP BY B2.ISBN, B2.title "
                + "ORDER BY count DESC;";
    }

    protected boolean check(){
        return true;
    }
}
