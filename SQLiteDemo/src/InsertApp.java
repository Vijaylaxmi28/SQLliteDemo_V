/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author spara
 */
public class InsertApp {
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:/C:\\sqlite\\sqlite-tools-win32-x86-3370200\\usersdb.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    /**
     * Insert a new row into the Moviess table
     *
     * @param Name
     * @param Actor
     * @param Actress
     * @param Director
     * @param Year_Of_Release
     * 
     * 
     */
    public void insert(String Name, String Actor,String Actress,String Director,int Year_Of_Release) {
        String sql = "INSERT INTO Moviess(Name,Actor,Actress,Director,Year_Of_Release) VALUES(?,?,?,?,?)";
        
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, Name);
            pstmt.setString(2, Actor);
            pstmt.setString(3, Actress);
            pstmt.setString(4, Director);
            pstmt.setInt(5, Year_Of_Release);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        InsertApp app = new InsertApp();
        // insert three new rows
        app.insert("3_idiots","Aamir Khan","Kareena Kapoor","Rajkumar H",2009);
        app.insert("PK","Aamir Khan","Anushkha Sharma","Rajkumar H", 2018);
        app.insert("YJHD","Ranbir K","Deepika P","Ayaan H", 2017);
        app.insert("Queen","Kangana R","Rajkumar R","Vikas B",2014);
        app.insert("Jab_we_met","Shahid K","Kareena K","Imtiaz Ali",2007);
    }
    
}
