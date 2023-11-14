package model;

import vue.GUI;

import java.sql.*;

public class Database {
    static final String user = "projet_gei_004";
    static final String url = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/"+user;

    static final String pass = "am3xiReZ";

    private  static Connection con = null;

    public static void main(String[] args){
        connectToDatabase();
        getUser("23@gma","root");

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

    public static void insertLineIntoMission(int idVuln,String location, String date, String description) {
        Statement statement=null;
        try {
            statement = con.createStatement();

        }catch(SQLException s){
            System.out.println("Error add line Table");
            //throw  new SQLException();
        }

        try {
            statement.executeUpdate("INSERT INTO Mission " + "VALUES ("+idVuln+", '"+location+"', '"+date+"', '"+description+"')");
        }catch (SQLException s){
            System.out.println("Insert User Line error");
            s.getErrorCode();
            s.getMessage();
        }

    }

    public static boolean getUser(String mail,String password){
        Statement statement=null;
        try {
            statement = con.createStatement();

        }catch(SQLException s){
            System.out.println("Error add line Table");
            //throw  new SQLException();
        }

        try{
            String query = String.format("SELECT * FROM User WHERE email='%s' and keyword='%s'",mail,password);
            //String query = "SELECT id FROM User;";
            System.out.println(query);
            ResultSet rs=statement.executeQuery(query);

            if (rs.next()) {
                String x = rs.getString("email");
                System.out.println(x);
                return  true;            }
        }catch (SQLException s){
            System.out.println("getUser Error");
            s.getErrorCode();
            s.getMessage();

        }
        return false;
    }






}
