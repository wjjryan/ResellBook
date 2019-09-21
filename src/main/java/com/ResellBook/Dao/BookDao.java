package com.ResellBook.Dao;

import com.ResellBook.Pojo.Book;
import com.ResellBook.Pojo.BuyerWantedBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {
     Book getBookInfo(String bookID);
     List<String> getSellerWanted(String sellerNum);
     int insertBuyerWanted(@Param("keyID") String keyID,@Param("buyerNum") String buyerNum,@Param("orderID") int orderID);
     List<BuyerWantedBook> getBuyerWanted(String buyerNum);
     String getSellerName(int orderID);
     int insertNews(@Param("newsID") String newsID,@Param("orderID")int orderID,@Param("buyerNum")String buyerNum,@Param("sellerNum")String sellerNum,@Param("newsStatus")int newsStatus);

}
