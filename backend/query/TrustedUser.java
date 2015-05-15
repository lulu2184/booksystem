package backend.query;

/**
 * Created by LU on 15/5/15.
 */
public class TrustedUser extends QueryForUser{
    private static final String[] field_name = {"username", "score"};

    public TrustedUser(Integer m){
        super(m);
        result.setFieldsName(field_name);
        column_name = new String[] {"declared_username", "score"};
    }

    protected void getSQL(){
        sql = "SELECT D.declared_username, SUM(D.trust_num) - SUM(1 - D.trust_num) as score FROM Declares D "
                +"GROUP BY D.declared_username "
                +"ORDER BY score DESC "
                +"LIMIT " + m.toString() + ";";
    }
}
