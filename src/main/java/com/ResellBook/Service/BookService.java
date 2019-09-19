package com.ResellBook.Service;


import java.util.Map;

public interface BookService {
    Map<String,Object> getSellingBook();
    Map<String,Object> getBookInformationByOrderID(int orderId);
}
