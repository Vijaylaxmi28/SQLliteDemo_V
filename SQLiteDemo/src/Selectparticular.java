/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
/**
 *
 * @author spara
 */
public class Selectparticular {
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
     * Get the warehouse whose capacity greater than a specified capacity
     * @param Name
     * @param Year_Of_Release
     */
    public void getName(double Year_Of_Release){
               String sql = "SELECT Name "
                          + "FROM Moviess WHERE Year_Of_Release=2007;	";
        
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            
            // set the value
            pstmt.setDouble(5,Year_Of_Release);
            //
            ResultSet rs  = pstmt.executeQuery();
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("Name") +  "\t" + 
                                   rs.getString("Actor") + "\t" +
                                   rs.getString("Actress") + "\t" +
                                   rs.getString("Director") + "\t" +
                                   rs.getDouble("Year_Of_Release"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        Selectparticular app = new Selectparticular();
        app.getName(2007);
    }

   
    
}
