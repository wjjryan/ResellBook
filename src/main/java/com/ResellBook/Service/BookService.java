package com.ResellBook.Service;


import java.util.Map;

public interface BookService {
    Map<String,Object> getBookInfo(String bookID);
    Map<String,Object> getSellerWanted(String sellerNum);
    Map<String,Object> insertBuyerWanted(String buyerNum,int orderID);
    Map<String,Object> getBuyerWanted(String buyerNum);

}
