package com.example.service;

import java.util.*;
import com.example.dao.StudentDao;
import com.example.model.Student;
import com.example.dao.StudentDaoImplementation;

public class StudentServiceImplementation implements StudentService{

    private StudentDao dao = new StudentDaoImplementation();
    
    public boolean addStudent(Student student){
        return dao.saveStudent(student);
    }

    @Override
    public Student getStudent(int id){
        return dao.FindStudent(id);
    }

    @Override
    public List<Student> getAllStudents(){
        return dao.FindAllStudents();
    }

    @Override
    public boolean updateStudent(int id,Student student){
        return dao.UpdateStudent(id,student);
    }

    @Override
    public boolean deleteStudent(int id){
        return dao.DeleteStudent(id);
    }
}
