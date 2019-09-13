package com.ResellBook.Dao;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.ResellBook.Pojo.Student;


public interface StudentDao {
    public List<Student> getStudent(Integer id);

}
