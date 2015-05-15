package backend.query;

/**
 * Created by LU on 15/5/15.
 */
public class PopAuthorInSemester extends QueryForSemester{
    private static final String field_name[] = {"Author name", "sold copies"};

    public PopAuthorInSemester(String year, String semester){
        super(year, semester);
        result.setFieldsName(field_name);
        column_name = new String[] {"aname", "copies"};
    }

    protected void generateSQL(){
        sql = "SELECT A.aname, SUM(I.num) as copies FROM AuthorOf A, Book B, InOrder I, Orders O "
                + "WHERE A.ISBN = B.ISBN AND B.ISBN = I.ISBN AND I.orderid = O.orderid AND O.order_date BETWEEN '" + begin_date + "' AND '" + end_date + "' "
                + "GROUP BY A.aname "
                + "ORDER BY copies DESC "
                + "LIMIT 10;";
    }
}
