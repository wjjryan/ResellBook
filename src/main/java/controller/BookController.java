package main.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    @RequestMapping(value = "/sellingBook")
    public void sellingBook(){}

    @RequestMapping(value = "/getBookInformationByOrderID")
    public void getBookInformationByOrderID(){}

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
