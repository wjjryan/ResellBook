package com.ResellBook.controller;

import com.ResellBook.Service.BookService;
import com.ResellBook.Service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class BookController {
    @Resource
    OrderService orderService;

    //获取已经上架的书
    @ResponseBody
    @RequestMapping(value = "/getSellingBook")
    public Map<String,Object> getSellingBook(){
        Map returnMap = orderService.getSellingBook();
        return returnMap;
    }

    @Resource
    BookService bookService;
    //获取书籍信息
    @ResponseBody
    @RequestMapping(value = "/getBookInfo")
    public Map<String,Object> getBookInfo(){
        String bookID = "9787113241452";
        Map<String,Object>returnMap = bookService.getBookInfo(bookID);
        return  returnMap;
    }


    //获取买家想要的书
    @ResponseBody
    @RequestMapping(value = "/getSellerWantedBook")
    public Map<String,Object> getSellerWantedBook(){
        String sellerNum = "201710098052";
        Map returnMap = bookService.getSellerWanted(sellerNum);
        return returnMap;
    }

    //添加用户想买的书
    @ResponseBody
    @RequestMapping(value = "/insertBuyerWantedBook")
    public Map<String,Object> insertBuyerWantedBook(){
        String buyerNum = "201710098052";
        int orderID = 1;
        Map returnMap = bookService.insertBuyerWanted(buyerNum,orderID);
        return returnMap;
    }

    //获取用户想买的书
    @ResponseBody
    @RequestMapping(value = "/getBuyerWantedBook")
    public Map<String,Object> getBuyerWantedBook(){
        String buyerNum = "201710098052";
        Map returnMap = bookService.getBuyerWanted(buyerNum);
        return returnMap;
    }

    //获取我的信息
    @ResponseBody
    @RequestMapping(value = "/getMyNews")
    public void getMyNews(){}

    //添加卖书订单(同时添加书籍信息)
    @ResponseBody
    @RequestMapping(value = "/insertOrders")
    public void insertOrders(){}

    //获取我卖的书籍的订单
    @ResponseBody
    @RequestMapping(value = "/getMyOrders")
    public void getMyOrders(){}

    //完成我卖的书籍的订单
    @ResponseBody
    @RequestMapping(value = "/updateMyOrdersStatus")
    public void updateMyOrdersStatus(){}

    //删除我卖的书籍的订单
    @ResponseBody
    @RequestMapping(value = "/delMyOrders")
    public void delMyOrders(){}

    //编辑我卖的书籍的订单
    @ResponseBody
    @RequestMapping(value = "/updateMyOrders")
    public void updateMyOrders(){}

    //添加我想要换的书
    @ResponseBody
    @RequestMapping(value = "/insertMyWantedBook")
    public void insertMyWantedBook(){}

}
