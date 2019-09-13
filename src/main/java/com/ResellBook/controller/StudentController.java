package main.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class StudentController {
    @RequestMapping(value = "/register")
    public void register(){}

    @RequestMapping(value = "/login")
    public void login(){}

    @RequestMapping(value = "/logout")
    public void logout(){}

    @RequestMapping(value = "/sendMessage")
    public void sendMessage(){}


}
