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
}
