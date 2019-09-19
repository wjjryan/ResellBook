package com.ResellBook.controller;

import com.ResellBook.Dao.BookDao;
import com.ResellBook.Dao.OrderDao;
import com.ResellBook.Dao.StudentDao;
import com.ResellBook.Pojo.Book;
import com.ResellBook.Pojo.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ResellBook.Pojo.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ResellBook.Service.StudentService;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Controller
public class StudentController {
    @Resource StudentService studentService;

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public Map<String,Object> register(){
        //模拟前端传输来的数据
        Student student = new Student("wjh","03","123456","计算机","2017","软件工程2班","123465789");
        Map<String,Object> returnMap = new HashMap<String, Object>();
        returnMap = studentService.registerStudent(student);
        System.out.println(returnMap);
        return returnMap;
    }

    @ResponseBody
    @RequestMapping(value = "/login")
    public Map<String,Object> login(){
        //模拟前端传输信息
        String id="1";
        String  pwd="123456";
        Map<String,Object> returnMap = new HashMap<String, Object>();
        returnMap = studentService.login(id,pwd);
        System.out.println(returnMap);
        return returnMap;
    }

    @Autowired
    private StudentDao studentDao;
    private OrderDao orderDao;
    BookDao bookDao;
    @ResponseBody
    @RequestMapping(value = "/test")
    public List<Orders> test(){
        List<Orders> student = orderDao.getStatusOrder(1);
        return student;
    }

    @RequestMapping(value = "/logout")
    public void logout(){}

    @RequestMapping(value = "/sendMessage")
    public void sendMessage(){

    }


}
