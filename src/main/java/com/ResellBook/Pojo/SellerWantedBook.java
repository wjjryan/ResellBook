package com.ResellBook.Pojo;


public class SellerWantedBook {
    private String studentNum;
    private String want;

    public SellerWantedBook(String studentNum, String want) {
        this.studentNum = studentNum;
        this.want = want;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getWant() {
        return want;
    }

    public void setWant(String want) {
        this.want = want;
    }
}
