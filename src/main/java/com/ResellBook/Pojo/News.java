package com.ResellBook.Pojo;


public class News {
    public String newsID;
    public String orderID;
    public String buyerName;
    public String sellerName;
    public int newsStatus;

    public News(String orderID, String buyerName, String sellerName, int newsStatus) {
        this.orderID = orderID;
        this.buyerName = buyerName;
        this.sellerName = sellerName;
        this.newsStatus = newsStatus;
    }

    public String getNewsID() {
        return newsID;
    }


    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public int getNewsStatus() {
        return newsStatus;
    }

    public void setNewsStatus(int newsStatus) {
        this.newsStatus = newsStatus;
    }
}
