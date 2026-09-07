package com.example.aopdemo.service;

import com.example.aopdemo.annotation.TrackExecutionTime;
import com.example.aopdemo.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentServiceInterface{

    @TrackExecutionTime(warnAfter = 2000,operation = "Creating new student")
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

    @TrackExecutionTime(warnAfter = 1500,operation = "Get Student Data")
    @Override
    public String getStudent(String s){
        try{
            Thread.sleep(2000);
        }catch (Exception e){}
        System.out.println(s);
        return s;
    }
}
