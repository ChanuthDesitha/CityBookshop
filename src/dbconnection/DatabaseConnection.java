/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Asus
 */
public class DatabaseConnection {
    public static Connection conn() {
        Connection conn = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/citybookshopdb","root","");
        } catch(Exception e) {
            System.out.println(e);
        }
        return conn;
    }
}
