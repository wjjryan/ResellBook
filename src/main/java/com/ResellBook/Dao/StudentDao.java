package com.ResellBook.Dao;

import com.ResellBook.Pojo.Student;
import java.util.List;

public interface StudentDao {
     List<String> getCollege();
     List<String> getGrade();
     List<String> getMajor(String college);
     String checkStudent(String num);
     int registerStudent(Student student);
     List<Student> getStudent(String num);
     String checkTel(String tel);
}
