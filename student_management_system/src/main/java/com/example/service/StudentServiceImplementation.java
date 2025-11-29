package com.example.service;

import java.util.List;
import com.example.dao.StudentDao;
import com.example.model.Student;
import com.example.dao.StudentDaoImplementation;

public class StudentServiceImplementation implements StudentService{

    private StudentDao dao = new StudentDaoImplementation();
    
    @Override
    public boolean addStudent(Student student){
        return dao.saveStudent(student);
    }

    @Override
    public Student getStudent(int id){
        return dao.findStudent(id);
    }

    @Override
    public List<Student> getAllStudents(){
        return dao.findAllStudents();
    }

    @Override
    public boolean updateStudent(Student student){
        return dao.updateStudent(student);
    }

    @Override
    public boolean deleteStudent(int id){
        return dao.deleteStudent(id);
    }
}
