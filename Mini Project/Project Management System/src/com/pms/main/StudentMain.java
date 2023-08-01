package com.pms.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.pms.model.Student;
import com.pms.dao.StudentDao;
import com.pms.dao.StudentDaoImpl;

public class StudentMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int regno, m1, m2, m3, total;
        String sname, choice;
        int ch;
        StudentDao dao = new StudentDaoImpl();
        List<Student> list = new ArrayList<>();
        
        do {
            System.out.println("CRUD Application");
            System.out.println("1.Create \n2.Read \n3.Update \n4.Delete");
            System.out.println("Enter choice");
            ch = scanner.nextInt();
            
            switch (ch) {
                case 1:
                    System.out.println("Enter student regno, name, and marks in 3 subjects");
                    regno = scanner.nextInt();
                    sname = scanner.next();
                    m1 = scanner.nextInt();
                    m2 = scanner.nextInt();
                    m3 = scanner.nextInt();
                    
                    Student student = new Student();
                    student.setRegno(regno);
                    student.setName(sname);
                    student.setWebScore(m1);
                    student.setSqlScore(m2);
                    student.setJavaScore(m3);
                    
                    dao.create(student);
                    break;
                    
                case 2:
                    System.out.println("Enter total");
                    total = scanner.nextInt();
                    list = dao.read(total);
                    
                    System.out.println("Students with a score greater than " + total);
                    for (Student obj : list) {
                        System.out.println(obj);
                    }
                    break;

                case 3:
                    System.out.println("Enter regno to update total");
                    regno = scanner.nextInt();
                    dao.update(regno);
                    break;
                    
                case 4:
                    System.out.println("Enter regno to delete");
                    regno = scanner.nextInt();
                    dao.delete(regno);
                    break;

                default:
                    System.out.println("Invalid choice");
            }

            System.out.println("Do you want to continue (yes/no)?");
            choice = scanner.next();
        } while (choice.equalsIgnoreCase("yes"));
        
        scanner.close();
    }
}
