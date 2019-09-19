package com.ResellBook.Pojo;


public class Orders {
    private int orderID;
    private String sellerNum;
    private int orderStatus;
    private String bookID;
    private int reward;
    private String remark;

    public Orders(String sellerNum, int orederStatus, String bookID, int reward, String remark) {
        this.sellerNum = sellerNum;
        this.orderStatus = orederStatus;
        this.bookID = bookID;
        this.reward = reward;
        this.remark = remark;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getSellerNum() {
        return sellerNum;
    }

    public void setSellerNum(String sellerNum) {
        this.sellerNum = sellerNum;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
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
