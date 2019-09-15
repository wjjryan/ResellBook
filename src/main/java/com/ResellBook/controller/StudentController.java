package com.ResellBook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ResellBook.Pojo.Student;

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

    @RequestMapping(value = "/login")
    public void login(){}

    @RequestMapping(value = "/logout")
    public void logout(){}

    @RequestMapping(value = "/sendMessage")
    public void sendMessage(){}


}
