/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author spara
 */
public class SQLiteCreat {
    public static void CreateNewTable(){
        // SQLite connection string
        String url = "jdbc:sqlite:/C:\\sqlite\\sqlite-tools-win32-x86-3370200\\usersdb.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS moviess (\n"
                + "   Name text NOT NULL,\n"
                + "   Actor text NOT NULL,\n"
                + "   Actress text NOT NULL,\n"
                + "   Director text NOT NULL,\n"
                + "   Year_Of_Release integer NOT NULL\n"
                + ");";
        
         try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
   
     public static void main(String[] args) {
        CreateNewTable();
    }
    
}
