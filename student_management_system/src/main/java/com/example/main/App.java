package com.example.main;
import java.util.List;
import java.util.Scanner;
import com.example.model.Student;
import com.example.service.StudentService;
import com.example.service.StudentServiceImplementation;

/**
 * Hello world!
 *
 */
public class App 
{
    
    public static void main( String[] args )
    {
        StudentService service = new StudentServiceImplementation();
        Scanner scan = new Scanner(System.in);
        while(true){
        System.out.println("1. Add Student");
        System.out.println("2. Find Student");
        System.out.println("3. Find all Students");
        System.out.println("4. Update Students");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
        System.out.print("Enter the option: ");
        
        int option = scan.nextInt();
        switch (option) {
            case 1:
                System.out.print("Enter the id   : ");
                int id = scan.nextInt();
                System.out.print("Enter the name : ");
                String name = scan.next();
                System.out.print("Enter the age  : ");
                int age = scan.nextInt();
                System.out.print("Enter the email: ");
                String email = scan.next();
                Student student = new Student(id, name, age, email);
                System.out.println(service.addStudent(student)?"Student details added":"Failed");
                break;
            case 2:
                System.out.print("Enter the id : ");
                id = scan.nextInt();
                student = service.getStudent(id);
                System.out.println(student!=null ? student: "Not Found");
                break;
            case 3:
                List<Student> students = service.getAllStudents();
                System.out.println(!students.isEmpty()? students:"No records found");
                break;
            case 6:
                System.exit(0);
            default:
                break;
        }
    }
    }
}
