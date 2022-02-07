/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author spara
 */
public class SelectApp {
    
    /**
     * Connect to the database
     * @return the Connection object
     */
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
     * select all rows in the moviess table
     */
    public void selectAll(){
        String sql = "SELECT Name, Actor, Actress, Director, Year_Of_Release FROM Moviess";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("Name") +  "\t" + 
                                   rs.getString("Actor") +  "\t" +
                                   rs.getString("Actress") +  "\t" + 
                                   rs.getString("Director") + "\t" +
                                   rs.getInt("Year_Of_Release"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SelectApp app = new SelectApp();
        app.selectAll();
    }

}
