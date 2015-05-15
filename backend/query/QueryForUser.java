package backend.query;

/**
 * Created by LU on 15/5/15.
 */
abstract public class QueryForUser extends Query{
    protected Integer m;
    protected QueryForUser(Integer m){
        this.m = m;
    }

    protected boolean check(){
        if (m <= 0){
            result.setUnvalid("number m should be positive.");
            return false;
        }
        return true;
    }
}
