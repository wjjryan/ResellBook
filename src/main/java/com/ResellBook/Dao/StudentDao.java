package com.ResellBook.Dao;

import com.ResellBook.Pojo.Student;
import java.util.List;

public interface StudentDao {
     List<Student> getStudent(String num);
     String checkStudent(String num);
     int registerStudent(Student student);
}
