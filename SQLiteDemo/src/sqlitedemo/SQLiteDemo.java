/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sqlitedemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author spara
 */
public class SQLiteDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //connection to 
        String jdbcurl = "jdbc:sqlite:/C:\\sqlite\\sqlite-tools-win32-x86-3370200\\usersdb.db";
          
         String sql = "CREATE TABLE IF NOT EXISTS warehouses (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	capacity real\n"
                + ");";
        
        
        try{
           Connection connection = DriverManager.getConnection(jdbcurl);
            // SQL statement for creating a new table
    
               Statement statement;
               statement = (Statement) connection.createStatement();
               ResultSet result;
               result = statement.executeQuery(sql);
               System.out.println("Database created successfully...");  
               
               /**while(result.next()){
                   String name = result.getString("name");
                   String email = result.getString("email");
                   
                   System.out.println(name + " | " + email);
               }*/
               
           }catch(SQLException e){
               System.out.println("Error connecton to SQLite DB");
               e.printStackTrace();
               
           }
    }
    
}
