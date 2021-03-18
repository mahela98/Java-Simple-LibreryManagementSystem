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
public class AddBookAdminMODEL {

    public static int canAddBookADMIN(String bookNameAB, String authorNameAB, String publishedDateAB, String discriptionAB) {
        PreparedStatement pstmt;
        Statement stmt;
        ResultSet rs;
        int rowCount = 0;
        try {
            //chech if the book is in th edata base
            stmt = DBConnection.getStatementConnection();
            pstmt = conn.prepareStatement("select * from books where bookName = ? AND authorName =? ");
            pstmt.setString(1, bookNameAB);
            pstmt.setString(2, authorNameAB);
            System.out.println("sql query " + pstmt.toString());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                rowCount++;
            }
            if (rowCount == 0) {
                pstmt = conn.prepareStatement("INSERT INTO books (bookName,authorName,publishedDate,discription)  VALUES (?,?,?,?)");
                pstmt.setString(1, bookNameAB);
                pstmt.setString(2, authorNameAB);
                pstmt.setString(3, publishedDateAB);
                pstmt.setString(4, discriptionAB);
                System.out.println("sql query " + pstmt.toString());
                pstmt.executeUpdate();
                rowCount = 0;
            } else if (rowCount > 0) {
                System.out.println("Book is Already in the data base");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error in dbsearch");
            rowCount = -3;
        }
        System.out.println(rowCount);
        return rowCount;
    }
}
