package com.ResellBook.controller;

import com.ResellBook.Dao.BookDao;
import com.ResellBook.Dao.OrderDao;
import com.ResellBook.Dao.StudentDao;
import com.ResellBook.Pojo.*;
import com.ResellBook.Service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    //注册
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public Map<String,Object> register(){
        //模拟前端传输来的数据
        Student student = new Student("wjh","03","123456","计算机","2017","软件工程2班","123465789");
        Map<String,Object> returnMap = studentService.registerStudent(student);
        System.out.println(returnMap);
        return returnMap;
    }

    //登录
    @ResponseBody
    @RequestMapping(value = "/login")
    public Map<String,Object> login(){
        //模拟前端传输信息
        String id="1";
        String  pwd="123456";
        Map<String,Object> returnMap = studentService.login(id,pwd);
        System.out.println(returnMap);
        return returnMap;
    }

    //获取学院及年级信息
    @ResponseBody
    @RequestMapping(value = "/getCollegeInfo")
    public Map<String,Object> getCollegeInfo(){
        Map<String,Object> returnMap = studentService.getCollegeInfo();
        return returnMap;
    }

    //获取专业信息
    @ResponseBody
    @RequestMapping(value = "/getMajor")
    public Map<String,Object> getMajor(){
        String college = "计算机工程学院";
        Map<String,Object> returnMap = studentService.getMajorByCollege(college);
        return returnMap;
    }

    @Resource
    SendMessageService sendMessageService;
    //发送信息
    @ResponseBody
    @RequestMapping(value = "/sendMessage")
    public Map<String,Object> sendMessage(){
        String tel = "18420013835";
        Message message =new Message();
        Map<String,Object> returnMap = new HashMap();
        int key = sendMessageService.sendMessage(SMSType.Register_Type,tel);
        if (key == 1){
            message.setStateCode(200);
            message.setMessage("短信发送成功");
        }
        if (key == 0){
            message.setStateCode(500);
            message.setMessage("短信发送失败,该用户已存在");
        }
        returnMap.put("message",message);
        return returnMap;
    }


}
