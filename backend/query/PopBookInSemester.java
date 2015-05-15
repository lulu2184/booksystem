package backend.query;

/**
 * Created by LU on 15/5/14.
 */
public class PopBookInSemester extends QueryForSemester{
    private static final String[] field_name = {"ISBN", "title", "sold copies"};

    public PopBookInSemester(String year, String semester){
        super(year,semester);
        result.setFieldsName(field_name);
        column_name = new String[]{"ISBN", "title", "copies"};
    }

    protected void generateSQL(){
        sql = "SELECT B.ISBN, B.title, SUM(I.num) as copies FROM Book B, InOrder I, Orders O "
                + "WHERE B.ISBN = I.ISBN AND I.orderid = O.orderid AND O.order_date BETWEEN '" + begin_date + "' AND '" + end_date + "' "
                + "GROUP BY B.ISBN, B.title "
                + "ORDER BY copies DESC "
                + "LIMIT 10;";
    }
}
