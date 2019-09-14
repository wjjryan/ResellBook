package main.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ResellBook.Pojo.Student;
import java.util.List;
import com.ResellBook.Service.StudentService;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Controller
public class StudentController {
    @Resource StudentService studentService;
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(){
        List<Student> name = studentService.getStudentService(1);
        System.out.println(name);
        return "ok";
    }

    @RequestMapping(value = "/login")
    public void login(){}

    @RequestMapping(value = "/logout")
    public void logout(){}

    @RequestMapping(value = "/sendMessage")
    public void sendMessage(){}


}
