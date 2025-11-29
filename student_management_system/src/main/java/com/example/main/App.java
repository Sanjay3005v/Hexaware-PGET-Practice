package com.example.main;

import java.util.List;
import com.example.model.Student;
import com.example.service.StudentService;
import com.example.service.StudentServiceImplementation;
import com.example.util.InputUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    private static StudentService service = new StudentServiceImplementation();
    public static void main( String[] args )
    {
        
        while(true){
            
            System.out.println("1. Add Student");
            System.out.println("2. Find Student");
            System.out.println("3. Find all Students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
        
            int option = InputUtil.getInt("Enter the option: ");

            switch (option) {

                case 1:
                    int id = InputUtil.getInt("Enter the id   : ");
                    String name = InputUtil.getString("Enter the name : ");
                    int age = InputUtil.getInt("Enter the age  : ");
                    String email = InputUtil.getString("Enter the email: ");
                    Student student = new Student(id, name, age, email);
                    System.out.println(service.addStudent(student)?"Student details added":"Failed");
                    break;

                case 2:
                    id = InputUtil.getInt("Enter the id   : ");
                    student = service.getStudent(id);
                    if(student!=null){
                        System.out.println(student);
                    }
                    break;

                case 3:
                    List<Student> students = service.getAllStudents();
                    if(!students.isEmpty()){
                        for(Student stud :students){
                            System.out.println(stud);
                        }
                    }
                    else{
                        System.out.println("No records found");
                    }
                    break;

                case 4:
                    id = InputUtil.getInt("Enter the id   : ");
                    student = service.getStudent(id);
                    if(student!=null){
                        student.setName(InputUtil.getString("Enter the name : "));
                        student.setAge(InputUtil.getInt("Enter the age  : "));
                        student.setEmail(InputUtil.getString("Enter the email: "));;
                        if(service.updateStudent(student)){
                            System.out.println("Student data updated");
                        }
                    }
                    break;

                case 5:
                    id = InputUtil.getInt("Enter the id   : ");
                    if(service.deleteStudent(id)){
                        System.out.println("Student data deleted");
                    }
                    break;

                case 6:
                    System.exit(0);

                default:
                    break;
            }
        
        }
    }
}
