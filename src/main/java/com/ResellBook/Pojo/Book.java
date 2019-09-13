package com.ResellBook.Pojo;

public class Book {
    public String bookID;
    public String bookName;
    public String publishHouse;
    public String editor;
    public String prise;

    public Book(String bookID, String bookName, String publishHouse, String editor, String prise) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.publishHouse = publishHouse;
        this.editor = editor;
        this.prise = prise;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublishHouse() {
        return publishHouse;
    }

    public void setPublishHouse(String publishHouse) {
        this.publishHouse = publishHouse;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getPrise() {
        return prise;
    }

    public void setPrise(String prise) {
        this.prise = prise;
    }
}
