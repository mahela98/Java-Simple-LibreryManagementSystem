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
public class ChangeUserPWMODEL {

    public static int changePW(int USERID, String newPassword) {
        int result = 1;
        PreparedStatement pstmt;
        Statement stmt;
        try {
            stmt = DBConnection.getStatementConnection();
            pstmt = conn.prepareStatement("UPDATE users SET password = ? WHERE userId = ?;");
            pstmt.setString(1, newPassword);
            pstmt.setInt(2, USERID);
            System.out.println(pstmt.toString());

            pstmt.executeUpdate();
            result = 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error in changing PW Model");
            result = 1;
        }
        System.out.println(result);
        return result;
    }
}
