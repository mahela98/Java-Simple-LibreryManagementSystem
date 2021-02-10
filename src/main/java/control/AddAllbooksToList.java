/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.DBConnection;
import model.DBSearch;
import view.HomePage;
import model.AllBookListGetting;
import view.Books;

/**
 *
 * @author EACMS
 */
public class AddAllbooksToList {

//    public static 
//    public static 

    public static ArrayList<Books> bookList() {
        ArrayList<Books> booklist = new ArrayList<>();
       booklist.clear();
        try {
            ResultSet rs = new AllBookListGetting().allbooks();
            System.out.println("list in control" + rs);
            while (rs.next()) {
                Books book;
                while (rs.next()) {
                    book = new Books(rs.getInt("bookId"), rs.getString("bookName"), rs.getString("authorname"), rs.getString("publishedDate"), rs.getString("discription"));
                    booklist.add(book);
                }
            }
            DBConnection.closeCon();
        } catch (Exception e) {
            System.err.println("Got an exception in addallbookstolist ");
            System.err.println(e.getMessage());
        }
        return booklist;
    }
    
    public static ArrayList<Books> borrowedbooks(int userId) {
        ArrayList<Books> borrowedBooklist = new ArrayList<>();
       borrowedBooklist.clear();
        try {
            ResultSet rs = new AllBookListGetting().borrowedBooks(userId);
            System.out.println("list in control" + rs);
            while (rs.next()) {
                Books borrowedBook;
                while (rs.next()) {
                    borrowedBook = new Books(rs.getInt("bookId"), rs.getString("bookName"), rs.getString("authorname"), rs.getString("publishedDate"), rs.getString("discription"));
                    borrowedBooklist.add(borrowedBook);
                }
            }
            DBConnection.closeCon();
        } catch (Exception e) {
            System.err.println("Got an exception in addallbookstolist ");
            System.err.println(e.getMessage());
        }
        return borrowedBooklist;
    }
    
    
}
