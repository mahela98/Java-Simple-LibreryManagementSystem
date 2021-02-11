/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import static model.DBConnection.conn;

/**
 *
 * @author EACMS
 */
public class DisplayUserDetails {

    PreparedStatement pstmt;
    Statement stmt;
    ResultSet rs;

    public ResultSet userDetailsinProfile(int USERID) {
        try {
            stmt = DBConnection.getStatementConnection();
            pstmt = conn.prepareStatement("SELECT * FROM users WHERE userId =?;");
            pstmt.setInt(1, USERID);
            System.out.println(pstmt.toString());
            this.rs = pstmt.executeQuery();
//            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error in Display user details in model");
        }
        System.out.println("in model " + rs);
        return this.rs;
    }

    public static int changeUSPW(int USERID, String email, String fullName, String userName, String mobile) {
        PreparedStatement pstmt;
        Statement stmt;
        int result = 1;
        try {
            stmt = DBConnection.getStatementConnection();
            pstmt = conn.prepareStatement("UPDATE users SET email = ?,fullName=?,userName=?,mobile=? WHERE userId = ?;");
            pstmt.setString(1, email);
            pstmt.setString(2, fullName);
            pstmt.setString(3, userName);
            pstmt.setString(4, mobile);
            pstmt.setInt(5, USERID);
            System.out.println(pstmt.toString());
            pstmt.executeUpdate();
            result = 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error in changing PW");
            result = 1;
        }
        System.out.println("in model " + result);
        return result;
    }

    public static int deleteAccount(int USERID) {
        PreparedStatement pstmt;
        Statement stmt;
        int result = 1;
        try {
            stmt = DBConnection.getStatementConnection();
            pstmt = conn.prepareStatement("DELETE FROM users WHERE userId=?;");
            pstmt.setInt(1, USERID);
            System.out.println(pstmt.toString());
            pstmt.executeUpdate();
            result = 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error in changing PW");
            result = 1;
        }
        System.out.println("in model " + result);
        return result;
    }
}
