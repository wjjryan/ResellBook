package com.ResellBook.ServiceImp;

import com.ResellBook.Dao.BookDao;
import com.ResellBook.Dao.OrderDao;
import com.ResellBook.Dao.StudentDao;
import com.ResellBook.Pojo.Book;
import com.ResellBook.Pojo.Message;
import com.ResellBook.Pojo.Orders;
import com.ResellBook.Pojo.Student;
import com.ResellBook.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImp  implements BookService {

    @Autowired
    BookDao  bookDao;
    OrderDao orderDao;
    StudentDao studentDao;

//上架书籍信息
    @Override
    public Map<String, Object> getSellingBook() {
        Message message =new Message();
        Map<String ,Object> returnMap=new HashMap();
        //用于存放获取信息:
        List<List<String>> information=new ArrayList<List<String>>();
        //获取状态为1的所以order
        List<Orders> ordersList = orderDao.getStatusOrder(1);
        //无该状态订单
        if(ordersList.size()==0)
        {
            message.setStateCode(500);
            message.setMessage("查找失败或无该状态订单");
        }
        else
        {
            for(Orders orders : ordersList)
            {
                List<String> list =new ArrayList<String>();
                Book book = bookDao.getBook(orders.getBookID());
                //将订单号，书名，价格，购买方式信息整合到list
                list.add(orders.getOrderID()+"");
                list.add(book.getBookName());
                list.add(book.getPrise());
                list.add(orders.getRemark());
                information.add(list);
                returnMap.put("information",information);

            }
            message.setStateCode(200);
            message.setMessage("查找成功");

        }
        returnMap.put("message",message);
        return returnMap;
    }
//订单详细信息
    @Override
    public Map<String, Object> getBookInformationByOrderID(int orderId) {

        Message message =new Message();
        Map<String ,Object> returnMap=new HashMap();
        Orders orders =orderDao.getOrderIdOrder(orderId);
        if(orders ==null)
        {
            message.setStateCode(500);
            message.setMessage("查找失败");
        }
        else
        {
            message.setStateCode(500);
            message.setMessage("查找成功");
            //查找书本信息
            Book book=bookDao.getBook(orders.getBookID());
            //查找卖家信息
            List<Student> stu= studentDao.getStudent(orders.getSellerNum());
            Student student=stu.get(0);
            returnMap.put("book",book);
            returnMap.put("order", orders);
            returnMap.put("student",student);
        }
        returnMap.put("message",message);
        return  returnMap;
    }
}
