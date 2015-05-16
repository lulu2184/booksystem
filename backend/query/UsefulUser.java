package backend.query;

/**
 * Created by LU on 15/5/15.
 */
public class UsefulUser extends QueryForUser{

    private static final String[] field_name = {"username", "score"};

    public UsefulUser(Integer m){
        super(m);
        result.setFieldsName(field_name);
        column_name = new String[] {"username", "score"};
    }

    protected void getSQL(){
        sql = "SELECT F.username, AVG(T.fscore) as score FROM Feedback F, "
                + "(SELECT R.fid as fid, AVG(R.rate_num) as fscore FROM Rate R GROUP BY R.fid) AS T "
                + "WHERE T.fid = F.fid "
                + "GROUP BY F.username "
                + "ORDER BY score DESC "
                + "LIMIT " + m.toString() + ";";
    }
}
