package frontend;

import backend.Connector;

/**
 * Created by LU on 15/5/3.
 */
public class Controller {

    public static void main(String[] args){
//        try{
//            Connector.getInstance();
//            System.out.println("Database connection established.");
//        }catch (Exception e){
//            System.out.println("Cannot connect to database server.");
//            return;
//        }
        System.out.println("           Database book manage system");
        new PageController().Do();
//        try{
//            Connector.close();
//            System.out.println("Database connection terminated.");
//        }catch (Exception e){
//            System.out.println("Cannot terminate the connection.");
//        }
    }

}
