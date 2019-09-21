package com.ResellBook.ServiceImp;

import com.ResellBook.Dao.BookDao;
import com.ResellBook.Pojo.*;
import com.ResellBook.Service.BookService;
import com.ResellBook.Tool.buildID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImp  implements BookService {

    @Autowired
    BookDao bookDao;

    @Override
    public Map<String,Object> getBookInfo(String bookID){
        Message message =new Message();
        Map<String ,Object> returnMap=new HashMap();
        Book book = bookDao.getBookInfo(bookID);
        if(book != null){
            message.setStateCode(200);
            message.setMessage("查找书名和价格成功");
            returnMap.put("bookInfo",book);
        }
        else{
            message.setStateCode(500);
            message.setMessage("查找书名和价格失败");
        }
        returnMap.put("message",message);
        return  returnMap;
    }

    @Override
    public Map<String,Object> getSellerWanted(String sellerNum){
        Message message =new Message();
        Map<String ,Object> returnMap=new HashMap();
        List<String> books = bookDao.getSellerWanted(sellerNum);
        if(books != null){
            message.setStateCode(200);
            message.setMessage("查找想要的书成功");
            returnMap.put("wantedBook",books);
        }
        else{
            message.setStateCode(500);
            message.setMessage("该用户无想要的书");
        }
        returnMap.put("message",message);
        return  returnMap;
    }

    @Override
    public Map<String,Object> insertBuyerWanted(String buyerNum,int orderID){
        Message message =new Message();
        Map<String ,Object> returnMap=new HashMap();
        String sellerNum = bookDao.getSellerName(orderID);
        int key1 = bookDao.insertBuyerWanted(buildID.uuid(),buyerNum,orderID);
        int key2 = bookDao.insertNews(buildID.uuid(),orderID,buyerNum,sellerNum,1);
        if( key1 == 1 && key2 == 1){
            message.setStateCode(200);
            message.setMessage("添加成功");
        }
        else{
            message.setStateCode(500);
            message.setMessage("添加失败");
        }
        returnMap.put("message",message);
        return  returnMap;
    }


    @Override
    public Map<String,Object> getBuyerWanted(String buyerNum){
        Message message =new Message();
        Map<String ,Object> returnMap=new HashMap();
        List<BuyerWantedBook> books = bookDao.getBuyerWanted(buyerNum);
        if(books != null){
            message.setStateCode(200);
            message.setMessage("查找收藏的书成功");
            returnMap.put("wantedBook",books);
        }
        else{
            message.setStateCode(500);
            message.setMessage("该用户无收藏的书");
        }
        returnMap.put("message",message);
        return  returnMap;
    }

}
