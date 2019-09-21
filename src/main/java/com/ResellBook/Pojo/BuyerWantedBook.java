package com.ResellBook.Pojo;


import org.omg.PortableInterceptor.INACTIVE;

public class BuyerWantedBook {
    private int orderID;
    private String bookName;
    private String prise;
    private int reward;
    private int orderStatus;

    public BuyerWantedBook(Integer orderID, String bookName, String prise, Integer reward, Integer orderStatus) {
        this.orderID = orderID;
        this.bookName = bookName;
        this.prise = prise;
        this.reward = reward;
        this.orderStatus = orderStatus;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPrise() {
        return prise;
    }

    public void setPrise(String prise) {
        this.prise = prise;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }
}
