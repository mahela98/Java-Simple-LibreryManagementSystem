/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.DBConnection;
import model.AddBookAdminMODEL;

/**
 *
 * @author EACMS
 */
public class AddBookAdminCon {

    public static int addbookAdmin(String bookNameAB, String authorNameAB, String publishedDateAB, String discriptionAB) {
        int result = -1;
        try {
            result = AddBookAdminMODEL.canAddBookADMIN(bookNameAB, authorNameAB, publishedDateAB, discriptionAB);
            DBConnection.closeCon();
        } catch (Exception e) {
            System.err.println("Got an exception! in Add Book con ");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Admin add book =" + result);
        return result;
    }
}
