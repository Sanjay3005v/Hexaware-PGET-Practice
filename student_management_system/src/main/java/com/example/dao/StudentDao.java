package com.example.dao;


import java.util.List;

import com.example.model.Student;

public interface StudentDao {
    public boolean saveStudent(Student student);
    public Student findStudent(int id);
    public List<Student> findAllStudents();
    public boolean updateStudent(Student student);
    public boolean deleteStudent(int id);
}
