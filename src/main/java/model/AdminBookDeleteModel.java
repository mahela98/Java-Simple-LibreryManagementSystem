/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static model.DBConnection.conn;

/**
 *
 * @author EACMS
 */
public class AdminBookDeleteModel {
    
    public static int adminDeleteBook(int BOOKID) {
        PreparedStatement pstmt;
        Statement stmt;
        int result = 1;
 
        try {
            stmt = DBConnection.getStatementConnection();
            pstmt = conn.prepareStatement("DELETE FROM books WHERE bookId=?;");
            pstmt.setInt(1, BOOKID);
            System.out.println(pstmt.toString());
            pstmt.executeUpdate();
            result = 0;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error in admin deleting book");
            System.err.println(e.getMessage());
            result = 1;
        }
        System.out.println("in book Delete Model " + result);
        return result;
    }
}
