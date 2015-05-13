package backend.query;

import backend.check.CheckResult;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LU on 15/5/13.
 */
public class QueryResult {

    private String message;
    private boolean valid;
    private List<String> fields_name;
    private List<List<String>> result;

    public QueryResult(){

    }

    public void setFieldsName(String[] str_array){
        List<String> a = Arrays.asList(str_array);
    }

    public void setUnvalid(){
        valid = false;
    }

    public void setResult(ResultSet )

}
