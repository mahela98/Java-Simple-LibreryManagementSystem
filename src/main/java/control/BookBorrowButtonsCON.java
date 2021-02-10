/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.AllBookListGetting;
import model.DBConnection;
import view.Books;
import model.BookBorrowButtonsModel;

/**
 *
 * @author EACMS
 */
public class BookBorrowButtonsCON {

    public static int bookButtonCHANGE(int USERID, int BOOKID) {
        int rowCount_BookBorrow = 0;
        try {
            ResultSet rs = new BookBorrowButtonsModel().allbooks(USERID, BOOKID);
            System.out.println("list in control" + rs);
            while (rs.next()) {
                rowCount_BookBorrow++;
            }
            DBConnection.closeCon();
        } catch (Exception e) {
            System.err.println("Got an exception in BOOK borrow Button ");
            System.err.println(e.getMessage());
        }
        return rowCount_BookBorrow;
    }
}
