package com.ResellBook.Pojo;


public class Order {
    private int orderID;
    private String sellerNum;
    private int orederStatus;
    private String bookID;
    private int reward;
    private String remark;

    public Order( String sellerNum, int orederStatus, String bookID, int reward, String remark) {
        this.sellerNum = sellerNum;
        this.orederStatus = orederStatus;
        this.bookID = bookID;
        this.reward = reward;
        this.remark = remark;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getSellerNum() {
        return sellerNum;
    }

    public void setSellerNum(String sellerNum) {
        this.sellerNum = sellerNum;
    }

    public int getOrederStatus() {
        return orederStatus;
    }

    public void setOrederStatus(int orederStatus) {
        this.orederStatus = orederStatus;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
