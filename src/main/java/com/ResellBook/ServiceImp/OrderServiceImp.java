package com.ResellBook.ServiceImp;

import com.ResellBook.Dao.OrderDao;
import com.ResellBook.Pojo.Message;
import com.ResellBook.Pojo.Orders;
import com.ResellBook.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    OrderDao orderDao;

    //上架书籍信息
    @Override
    public Map<String, Object> getSellingBook() {
        Message message =new Message();
        Map<String ,Object> returnMap=new HashMap();
        //获取所以有效的order
        List<Orders> ordersList = orderDao.getStatusOrder(1);
        if(ordersList != null){
            message.setStateCode(200);
            message.setMessage("获取订单成功");
        }else{
            message.setStateCode(500);
            message.setMessage("暂无有效订单");
        }
        returnMap.put("message",message);
        returnMap.put("orderInfo",ordersList);
        return returnMap;
    }
}
