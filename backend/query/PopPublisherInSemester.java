package backend.query;

/**
 * Created by LU on 15/5/15.
 */
public class PopPublisherInSemester extends QueryForSemester{
    private static final String[] field_name = {"publisher", "sold copies"};

    public PopPublisherInSemester(String year, String semester){
        super(year, semester);
        result.setFieldsName(field_name);
        column_name = new String[]{"pname", "copies"};
    }

    protected void generateSQL(){
        sql = "SELECT B.pname, SUM(I.num) as copies FROM Book B, InOrder I, Orders O "
                + "WHERE B.ISBN = I.ISBN AND I.orderid = O.orderid AND O.order_date BETWEEN '" + begin_date + "' AND '" + end_date + "' "
                + "GROUP BY B.pname "
                + "ORDER BY copies DESC "
                + "LIMIT 10;";
    }
}
