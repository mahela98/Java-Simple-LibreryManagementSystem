/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author EACMS
 */
public class Books {
     private int bookId;
    private String bookName,authorName,publishedDate,discription;

    public Books(int bookId, String bookName, String authorName, String publishedDate, String discription) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.publishedDate = publishedDate;
        this.discription = discription;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getDiscription() {
        return discription;
    }


}
