package com.example.aopdemo.service;

import com.example.aopdemo.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public Student createStudent(Student student){
        System.out.println("Student Saved");
//        try{
            throw new RuntimeException("Some Error Occured");
//        }catch (Exception e){}
//        return student;
    }

    public String dummyMethod(String s){
        System.out.println("dummyMethod called");
        return s;
    }
}
