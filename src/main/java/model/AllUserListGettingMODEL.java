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
public class AllUserListGettingMODEL {
    PreparedStatement pstmt;
    Statement stmt;
    ResultSet rs;

    public ResultSet allUsers() {
        try {
            stmt = DBConnection.getStatementConnection();
            pstmt = conn.prepareStatement("select * from users");
            System.out.println(pstmt.toString());

            this.rs = pstmt.executeQuery();
//            System.out.println(rs);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error in allUser list getting");
        }
        System.out.println("in model " + rs);
        return this.rs;
    }
}
