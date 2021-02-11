/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import static model.DBConnection.conn;
import view.Books;

/**
 *
 * @author EACMS
 */
public class UserSignInModel {

    public static int canSignIn(String name, String UserName, String email, String mobile, String Password) {
        PreparedStatement pstmt;
        Statement stmt;
        ResultSet rs;
        int rowCount = 0;
        try {
            stmt = DBConnection.getStatementConnection();
            pstmt = conn.prepareStatement("select * from users where email = ? ");
            pstmt.setString(1, email);
            System.out.println("sql query " + pstmt.toString());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                rowCount++;
            }
            if (rowCount == 0) {
                pstmt = conn.prepareStatement("INSERT INTO users (email,fullName,userName,mobile,password)  VALUES (?,?,?,?,?)");
                pstmt.setString(1, email);
                pstmt.setString(2, name);
                pstmt.setString(3, UserName);
                pstmt.setString(4, mobile);
                pstmt.setString(5, Password);
                System.out.println("sql query " + pstmt.toString());
                pstmt.executeUpdate();
                rowCount = 0;
            }
            else if (rowCount > 0) {
                System.out.println("Email is already taken in model");
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error in dbsearch");
        }

        System.out.println(rowCount);
        return rowCount;

    }

    public static int gettingUId(String email, String password) {
        PreparedStatement pstmt;
        Statement stmt;
        int USERID = 0;
        try {
            stmt = DBConnection.getStatementConnection();
            pstmt = conn.prepareStatement("select * from users where email = ? AND password= ?");
            pstmt.setString(1, email);
            pstmt.setString(2, password);

            System.out.println("sql query " + pstmt.toString());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                USERID = rs.getInt("userId");
                System.out.println(USERID);
            }
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());

        }
        return USERID;
    }
}
