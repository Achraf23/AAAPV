package model;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    static final String user = "projet_gei_004";
    static final String url = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/"+user;

    static final String pass = "am3xiReZ";

    private  static Connection con = null;
    private static Statement statement=null;


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

    private static void initQuery(){
        statement=null;
        try {
            statement = con.createStatement();

        }catch(SQLException s){
            System.out.println("Error createStatement database");
            //throw  new SQLException();
        }
    }


    public static boolean insertLineIntoUser(String name, String firstname, String mail, String password, EnumUser type) {
        initQuery();

        try {
            statement.executeUpdate("INSERT INTO User (nom,firstname,mailUser, keyword, typeUser)" + "VALUES ('"+name+"', '"+firstname+"', '"+mail+"', '"+password+"', '"+type+"')");
            return true;
        }catch (SQLException s){
            System.out.println("User already in");
            s.getErrorCode();
            s.getMessage();
            return false;
        }

    }

    public static boolean insertLineIntoMission(Mission m) {
        initQuery();

        try {
            statement.executeUpdate("INSERT INTO Mission " + "VALUES ('"+
                    m.getVulnerable().getMail()+"','"+m.getLocation()+"', '"+m.getDate()+"', '"+m.getDescription()+"')");
            return true;
        }catch (SQLException s){
            System.out.println("Insert Mission error");
            s.getErrorCode();
            s.getMessage();
            return false;
        }

    }

    public static String getUserPassword(String mail) throws SQLException{
        initQuery();

        String query = String.format("SELECT * FROM User WHERE mailUser='%s'",mail);
            //String query = "SELECT id FROM User;";
            //System.out.println(query);
        ResultSet rs=statement.executeQuery(query);
        if (rs.next()) {
            String m = rs.getString("mailUser");
            System.out.println(m);  //print le mail s'il existe déja dans la bdd
            return rs.getString("keyword");  //retourne le password associé au mail
        }

        return null;
    }

    public static ArrayList<Mission> getAllMissions(){
        ArrayList<Mission> missions=new ArrayList<Mission>();

        initQuery();

        try{
            String query = String.format("SELECT * FROM Mission natural join User");

            ResultSet rs=statement.executeQuery(query);
            while (rs.next()) {
                Vulnerable v =new Vulnerable(rs.getString("nom"),rs.getString("firstname"),rs.getString("mailUser"),rs.getString("keyword"));
                missions.add(new Mission(v,rs.getString("location"),rs.getString("dateMission"),rs.getString("description")));
            }
        }catch (SQLException s){
            System.out.println("getUser Error");
            s.getErrorCode();
            s.getMessage();

        }

        return missions;

    }

    public static void deleteMissions(){
        initQuery();
        try {
            statement.executeUpdate("delete FROM Mission ");
        }catch (SQLException s){
            System.out.println("deleteMissions error");
            s.getErrorCode();
            s.getMessage();
        }
    }

    public static void deleteUsers(){
        initQuery();
        try {
            statement.executeUpdate("delete FROM User ");
        }catch (SQLException s){
            System.out.println("deleteUsers error");
            s.getErrorCode();
            s.getMessage();
        }
    }








}
