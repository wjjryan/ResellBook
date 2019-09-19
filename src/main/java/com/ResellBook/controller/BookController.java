package com.ResellBook.controller;

import com.ResellBook.Service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class BookController {
    @Resource
    BookService bookService;

    @ResponseBody
    @RequestMapping(value = "/sellingBook")
    public void sellingBook(){
        Map<String,Object> returnMap= bookService.getSellingBook();
        System.out.println(returnMap);
    }

    @ResponseBody
    @RequestMapping(value = "/getBookInformationByOrderID")
    public void getBookInformationByOrderID(){
        //模拟前端传来信息
        int orderId=1;
        Map<String,Object>returnMap=bookService.getBookInformationByOrderID(orderId);
        System.out.println(returnMap);
    }

    @RequestMapping(value = "/sellerWantedBook")
    public void sellerWantedBook(){}

    @RequestMapping(value = "/buyerWantedBook")
    public void buyerWantedBook(){}

    @RequestMapping(value = "/myOrders")
    public void myOrders(){}

    @RequestMapping(value = "/OderInformation")
    public void OderInformation(){}

    @RequestMapping(value = "/myNews")
    public void myNews(){}


}
