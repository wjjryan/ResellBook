package com.ResellBook.ServiceImp;

import com.ResellBook.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ResellBook.Dao.StudentDao;
import com.ResellBook.Pojo.Student;
import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> getStudentService (int id){
      List<Student> name = studentDao.getStudent(id);
      return name;
    }
}

