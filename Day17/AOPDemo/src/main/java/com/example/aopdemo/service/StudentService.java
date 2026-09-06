package com.example.aopdemo.service;

import com.example.aopdemo.dto.Student;
import jdk.jfr.Timestamp;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentServiceInterface{

    @Override
    public Student createStudent(Student student){
        System.out.println("Student Saved");
//        try{
//            throw new RuntimeException("Some Error Occured");
//        }catch (Exception e){}
        return student;
    }

    public String dummyMethod(String s){
        System.out.println("dummyMethod called");
        return s;
    }

    @Override
    public String getStudent(String s){
        System.out.println(s);
        return s;
    }
}
