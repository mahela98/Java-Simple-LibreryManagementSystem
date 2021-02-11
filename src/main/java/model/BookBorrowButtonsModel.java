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
public class BookBorrowButtonsModel {

    PreparedStatement pstmt;
    Statement stmt;
    ResultSet rs;

    public ResultSet allbooks(int USERID, int BOOKID) {
        try {
            stmt = DBConnection.getStatementConnection();
            pstmt = conn.prepareStatement("select * from bookborrowjava where bookId = ? AND userId= ? AND bookReturned=?");
            pstmt.setInt(1, BOOKID);
            pstmt.setInt(2, USERID);
            pstmt.setInt(3, 0);
            System.out.println(pstmt.toString());

            this.rs = pstmt.executeQuery();
//            System.out.println(rs);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error in book borrow buttons");
        }
        System.out.println("in model " + rs);
        return this.rs;
    }

    public static int borrowbookButtonClicked(int USERID, int BOOKID) {
        PreparedStatement pstmt;
        Statement stmt;
        int result = 1;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime returnDate = LocalDateTime.now().plusDays(7);
        String borrowedDateDB = dtf.format(now);
        String returnDateDB = dtf.format(returnDate);
        System.out.println("UserId = " + USERID);
        System.out.println("BookId = " + BOOKID);
        System.out.println("borrowed Date = " + dtf.format(now));
        System.out.println("return Date = " + dtf.format(returnDate));
        try {
            stmt = DBConnection.getStatementConnection();
            pstmt = conn.prepareStatement("INSERT INTO bookBorrowjava (userId,bookId,borrowdate,returnDate,bookReturned)  VALUES (?,?,?,?,?)");
            pstmt.setInt(1, USERID);
            pstmt.setInt(2, BOOKID);
            pstmt.setString(3, borrowedDateDB);
            pstmt.setString(4, returnDateDB);
            pstmt.setInt(5, 0);
            System.out.println(pstmt.toString());
            pstmt.executeUpdate();
            result = 0;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error in book borrow buttons");
            System.err.println(e.getMessage());
            result = 1;
        }
        System.out.println("in model " + result);
        return result;
    }

    public static int bookReturnButtonClicked(int USERID, int BOOKID) {
        PreparedStatement pstmt;
        Statement stmt;
        int result = 1;
        try {
            stmt = DBConnection.getStatementConnection();
            pstmt = conn.prepareStatement("UPDATE bookborrowjava SET bookReturned =? WHERE bookId=? AND userId=?");
            pstmt.setInt(1, 1);
            pstmt.setInt(2, BOOKID);
            pstmt.setInt(3, USERID);
            System.out.println(pstmt.toString());
            pstmt.executeUpdate();
            result = 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error in book return button");
            System.err.println(e.getMessage());
            result = 1;
        }
        System.out.println("in model " + result);
        return result;
    }

}
