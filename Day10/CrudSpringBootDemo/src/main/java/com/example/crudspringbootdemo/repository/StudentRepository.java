package com.example.crudspringbootdemo.repository;

import com.example.crudspringbootdemo.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentRepository {

    public Student saveStudent(Student studentReq){
        System.out.println("Inside Student Repository");
        Student s1=new Student();
        s1.setName("Aditya");
        s1.setAge(22);
        s1.setEmail("aditya@gmail.com");
        s1.setRollNo(101);
        s1.setSubject("Spring Framework");
        System.out.println("Exiting Student Repository");
        return s1;
    }
}
