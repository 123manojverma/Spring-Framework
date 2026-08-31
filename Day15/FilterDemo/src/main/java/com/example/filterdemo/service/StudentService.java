package com.example.filterdemo.service;

import com.example.filterdemo.dto.Student;
import com.example.filterdemo.dto.StudentResponseDto;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public StudentResponseDto createStudent(Student student){
//        System.out.println("Student Created");
//        System.out.println(student.getName());
//        System.out.println(student.getEmail());

//        try {
//            Thread.sleep(2000);
//        }catch (Exception e){}

        StudentResponseDto responseDto=new StudentResponseDto();
        responseDto.setName(student.getName());
        responseDto.setMessage("Student is saved successfully");
        return responseDto;
    }
}
