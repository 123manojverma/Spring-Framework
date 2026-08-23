package com.example.crudspringbootdemo.service;

import com.example.crudspringbootdemo.entity.Student;
import com.example.crudspringbootdemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public Student createStudent(Student studentReq){
//        business logic
//        store to db
        System.out.println("Inside Student Service");
        Student studentRes=studentRepository.saveStudent(studentReq);
        System.out.println("Exiting Student Service");
        return studentRes;
    }
//    1. End point listen (/app/students  POST)

//    2. Business logic

//    3. Interact with DB to store

//    4. Response back to client (postman)
}
