package main.java.Pojo;

public class SellerWantedBook {
    public String studentBook;
    public String want;

    public SellerWantedBook(String studentBook, String want) {
        this.studentBook = studentBook;
        this.want = want;
    }

    public String getStudentBook() {
        return studentBook;
    }

    public void setStudentBook(String studentBook) {
        this.studentBook = studentBook;
    }

    public String getWant() {
        return want;
    }

    public void setWant(String want) {
        this.want = want;
    }
}
