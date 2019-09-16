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
    private SendMessageService sendMessageService;

    //学生注册
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



}

