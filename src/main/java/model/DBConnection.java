/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

//import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    static Connection conn;
    static Statement stat = null;

    public static Statement getStatementConnection() {
        try {
            String myUrl = "jdbc:mysql://localhost/java_login?serverTimezone=UTC";
            conn = DriverManager.getConnection(myUrl, "root", "");
//Create the connection
            stat = conn.createStatement();
            System.out.println("Connected to DB");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stat;
    }

    public static void closeCon() throws SQLException {
        conn.close();
    }
}
