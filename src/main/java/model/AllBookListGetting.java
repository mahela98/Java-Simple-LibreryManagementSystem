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
public class AllBookListGetting {

    PreparedStatement pstmt;
    Statement stmt;
    ResultSet rs;
    ResultSet rsborrowedBooks;

    public ResultSet allbooks() {
        try {
            stmt = DBConnection.getStatementConnection();
            pstmt = conn.prepareStatement("select * from books");
            System.out.println(pstmt.toString());

            this.rs = pstmt.executeQuery();
//            System.out.println(rs);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error in allbook list getting");
        }
        System.out.println("in model " + rs);
        return this.rs;
    }

    public ResultSet borrowedBooks(int userID) {
        try {
            stmt = DBConnection.getStatementConnection();
            pstmt = conn.prepareStatement("SELECT books.bookId, books.bookName, books.authorName,books.publishedDate,books.discription FROM bookborrowjava INNER JOIN books ON bookborrowjava.bookId=books.bookId WHERE bookborrowjava.userId=? AND bookborrowjava.bookReturned=?;");
//            pstmt = conn.prepareStatement("SELECT *FROM books");
            pstmt.setInt(1, userID);
           pstmt.setInt(2, 0);
            System.out.println(pstmt.toString());

            this.rsborrowedBooks = pstmt.executeQuery();
//            System.out.println(rs);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error in allbook list getting");
        }
        System.out.println("in model " +  this.rsborrowedBooks);
        return this.rsborrowedBooks;
    }
}
