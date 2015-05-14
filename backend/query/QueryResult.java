package backend.query;

import backend.check.CheckResult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LU on 15/5/13.
 */
public class QueryResult {

    public String message;
    public boolean valid;
    public List<String> fields_name;
    public List<List<String>> result;

    public QueryResult(){

    }

    public void setFieldsName(String[] str_array){
        fields_name = Arrays.asList(str_array);
    }

    public void setUnvalid(String message){
        this.message = message;
        valid = false;
    }

    public void setResult(ResultSet rs, String[] columns_name) throws SQLException{
        valid = true;
        result = new ArrayList<List<String>>();
        while (rs.next()){
            List <String> tmp = new ArrayList<String>();
            for (String str : columns_name){
                tmp.add(rs.getString(str));
            }
            result.add(tmp);
        }
    }

    public boolean isValid(){
        return valid;
    }

    public String getMessage(){
        return message;
    }
}
