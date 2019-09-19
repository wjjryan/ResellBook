package com.ResellBook.Dao;


import com.ResellBook.Pojo.Orders;

import java.util.List;

public interface OrderDao {
    List<Orders> getStatusOrder(Integer num);
    Orders getOrderIdOrder(Integer orderId);
}
