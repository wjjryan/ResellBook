package com.ResellBook.ServiceImp;

import com.ResellBook.Pojo.Message;
import com.ResellBook.Pojo.SMSType;
import com.ResellBook.Service.SendMessageService;
import com.ResellBook.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ResellBook.Dao.StudentDao;
import com.ResellBook.Pojo.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentDao studentDao;

    //获取学院及年级信息
    @Override
    public  Map<String,Object> getCollegeInfo(){
        Message message = new Message();
        Map<String,Object> returnMap = new HashMap();
        List<String> college = studentDao.getCollege();
        List<String> grade = studentDao.getGrade();
        if(college != null && grade != null ){
            message.setStateCode(200);
            message.setMessage("获取学院信息成功");
            returnMap.put("college",college);
            returnMap.put("grade",grade);
        }
        else{
            message.setStateCode(500);
            message.setMessage("获取学院信息失败");
        }
        returnMap.put("message",message);
        return  returnMap;
    }

    public Map<String,Object> getMajorByCollege(String college){
        Message message = new Message();
        Map<String,Object> returnMap = new HashMap();
        List<String> major = studentDao.getMajor(college);
        if(major != null ){
            message.setStateCode(200);
            message.setMessage("获取专业信息成功");
            returnMap.put("major",major);
        }
        else{
            message.setStateCode(500);
            message.setMessage("获取专业信息失败");
        }
        returnMap.put("message",message);
        return  returnMap;

    }

    //学生注册
    @Autowired
    private SendMessageService sendMessageService;
    @Override
    public Map<String,Object> registerStudent(Student student) {
        Map<String, Object> returnMap = new HashMap();
        Message message = new Message();
        String code="abcd";
        if(!code.equals(sendMessageService.getCode(SMSType.ForgetPasswd_Type,student.getTel()))){
            message.setStateCode(400);
            message.setMessage("验证码错误");
        }
        int key = 1;
        if (student.getStudentNum().equals(studentDao.checkStudent(student.getStudentNum()))) {
            key = 0;}
        //数据插入成功
        if (key == 1) {
            studentDao.registerStudent(student);
            message.setStateCode(200);
            message.setMessage("注册成功");
        }
        //数据插入失败
        else{
            message.setStateCode(500);
            message.setMessage("注册失败,用户已存在");
        }
        returnMap.put("message",message);
        return returnMap;
    }

    @Override
    public Map<String, Object> login(String num, String pwd) {
        Map<String, Object> returnMap = new HashMap();
        List<Student> stu = studentDao.getStudent(num);
        System.out.println(stu.get(0));
        System.out.println(stu.size());
        Message message = new Message();
        if (stu.size() > 0 && stu.get(0).getStudentPasswd().equals(pwd)) {
            message.setStateCode(200);
            message.setMessage("登录成功");
            returnMap.put("student",stu.get(0));
        } else {
            message.setStateCode(500);
            message.setMessage("登录失败");
        }
        returnMap.put("message",message);
        return  returnMap;
    }





}

