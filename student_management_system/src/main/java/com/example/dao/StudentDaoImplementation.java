package com.example.dao;

import java.sql.*;

import com.example.exception.StudentNotFound;
import com.example.model.Student;
import com.example.util.DBConnection;
import java.util.*;

public class StudentDaoImplementation implements StudentDao {
    public boolean saveStudent(Student student) {
        String query = "insert into student values(?,?,?,?)";
        try(Connection connection = DBConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,student.getId());
            statement.setString(2,student.getName());
            statement.setInt(3, student.getAge());
            statement.setString(4,student.getEmail());
            statement.execute();
            return true;    
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public Student findStudent(int id){
        String query = "select * from student where id = ?";
        Student student = null;
        try(Connection connection = DBConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                student = new Student(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
            }
            else{
                throw new StudentNotFound("Student with id "+id+" is not present");
            }
        } 
        catch(Exception e){
            e.printStackTrace();
        }
        return student;
    }
    @Override
    public List<Student> findAllStudents(){
        String query= "select * from student";
        List<Student> students = new ArrayList<>();
        try(Connection connection = DBConnection.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                Student student = new Student(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
                if(student!=null){
                    students.add(student);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return students;
    }
    @Override
    public boolean updateStudent(Student student){
        String query = "update student set name= ?,age= ?,email= ? where id =?";
        try(Connection connection = DBConnection.getConnection()){
            PreparedStatement statement  = connection.prepareStatement(query);
            statement.setString(1,student.getName());
            statement.setInt(2,student.getAge());
            statement.setString(3,student.getEmail());
            statement.setInt(4,student.getId());
            statement.executeUpdate();
            return true;
            }
            catch(Exception e){
                e.printStackTrace();
            }
            return false;
    }
    @Override
    public boolean deleteStudent(int id){
        String query = "delete from student where id=?";
        try(Connection connection = DBConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            int rows = statement.executeUpdate();
            if(rows>0){
                return true;
            }
            else{
                throw new StudentNotFound("Student with id "+id+" is not present");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
