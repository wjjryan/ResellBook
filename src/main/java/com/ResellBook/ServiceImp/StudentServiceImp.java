package com.ResellBook.ServiceImp;

import com.ResellBook.Pojo.Message;
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

    @Override
    public List<Student> getStudentService (String num){
      List<Student> name = studentDao.getStudent(num);
      return name;
    }

    @Override
    public Map<String,Object> registerStudent(Student student) {
        Map<String, Object> returnMap = new HashMap();
        Message message = new Message();
        int key = studentDao.registerStudent(student);
        //数据插入成功
        if (key == 1) {
            message.setStateCode(200);
            message.setMessage("注册成功");
        }
        //数据插入失败
        else{
            message.setStateCode(500);
            message.setMessage("注册失败");
        }
        returnMap.put("message",message);
        return returnMap;
    }
}

