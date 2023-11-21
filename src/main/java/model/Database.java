package model;

import java.sql.*;

public class Database {
    static final String user = "projet_gei_004";
    static final String url = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/"+user;

    static final String pass = "am3xiReZ";

    private  static Connection con = null;

    public static void main(String[] args){
        connectToDatabase();

    }


    public static void connectToDatabase(){
        if(con==null){
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

    }


    //Testing Insert Line Table ==> Will change later
    public static void insertLineIntoUser(String name, String firstname, String mail, String password) {
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
            statement.executeUpdate("INSERT INTO User " + "VALUES ('"+name+"', '"+firstname+"', '"+mail+"', '"+password+"')");
        }catch (SQLException s){
            System.out.println("Insert User Line error");
            s.getErrorCode();
            s.getMessage();
        }

    }

    public static void insertLineIntoMission(String location, String date, String description) {
        Statement statement=null;
        try {
            statement = con.createStatement();

        }catch(SQLException s){
            System.out.println("Error add line Table");
            //throw  new SQLException();
        }

        try {
            statement.executeUpdate("INSERT INTO Mission " + "VALUES ('"+location+"', '"+date+"', '"+description+"')");
        }catch (SQLException s){
            System.out.println("Insert User Line error");
            s.getErrorCode();
            s.getMessage();
        }

    }

    public static String associatedPassword(String mail){
        Statement statement=null;
        try {
            statement = con.createStatement();

        }catch(SQLException s){
            System.out.println("Error createStatement database");
            //throw  new SQLException();
        }

        try{
            String query = String.format("SELECT * FROM User WHERE email='%s'",mail);
            //String query = "SELECT id FROM User;";
            //System.out.println(query);
            ResultSet rs=statement.executeQuery(query);
            System.out.println("before");
            if (rs.next()) {
                System.out.println("in");
                String m = rs.getString("email");
                System.out.println(m);  //print le mail s'il existe déja dans la bdd
                return rs.getString("keyword");  //retourne le password associé au mail
            }
        }catch (SQLException s){
            System.out.println("getUser Error");
            s.getErrorCode();
            s.getMessage();

        }
        return null;
    }






}
