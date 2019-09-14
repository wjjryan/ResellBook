package com.ResellBook.Service;

import com.ResellBook.Pojo.Student;
import java.util.List;
import java.util.Map;

public interface StudentService {
     List<Student> getStudentService(String num);
     Map<String,Object> registerStudent(Student student);
}