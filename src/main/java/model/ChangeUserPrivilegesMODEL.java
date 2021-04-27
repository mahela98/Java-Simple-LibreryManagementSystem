/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.Statement;
import static model.DBConnection.conn;

/**
 *
 * @author EACMS
 */
public class ChangeUserPrivilegesMODEL {

    public static int changePrivilage(int userId, int adminOrNot) {
        int result = 1;
        PreparedStatement pstmt;
        Statement stmt;

        try {
            stmt = DBConnection.getStatementConnection();
            pstmt = conn.prepareStatement("UPDATE users SET adminOrNot = ? WHERE userId = ?;");
            pstmt.setInt(1, adminOrNot);
            pstmt.setInt(2, userId);
            System.out.println(pstmt.toString());
            pstmt.executeUpdate();
            result = 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error in changing privileges Model");
            result = 1;
        }
        return result;
    }
}
