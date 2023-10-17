package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Database {
    static final String user = "projet_gei_004";
    static final String url = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/"+user;

    static final String pass = "am3xiReZ";

    static  Database db;

    private  static Connection con = null;


    public static void connectToDatabase(){
        try {
            con = DriverManager.getConnection(url, user,
                    pass);

            System.out.println("Success connection");

            // Do something with the Connection

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }


    //Testing Insert Line Table ==> Will change later
    public static void insertLineIntoUser(int id,String name, String firstname, String mail, String password) {
        Statement statement=null;
        try {
            statement = con.createStatement();

        }catch(SQLException s){
            System.out.println("Error add line Table");
            //throw  new SQLException();
        }
        // insert the data
        //statement.executeUpdate("INSERT INTO User " + "VALUES (1, 'Simpson', 'Mr.', 'Springfield', 'root')");

        try {
            statement.executeUpdate("INSERT INTO User " + "VALUES ("+id+", '"+name+"', '"+firstname+"', '"+mail+"', '"+password+"')");
        }catch (SQLException s){
            System.out.println("Insert User Line error");
            s.getErrorCode();
            s.getMessage();
        }

    }






}
