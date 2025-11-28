package com.example.dao;


import java.util.List;

import com.example.model.Student;

public interface StudentDao {
    public boolean saveStudent(Student student);
    public Student FindStudent(int id);
    public List<Student> FindAllStudents();
}
