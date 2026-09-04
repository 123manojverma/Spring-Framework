package com.example.aopintroduction.repository;

import com.example.aopintroduction.dto.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    public void save(Student student){
        System.out.println("Student saved successfully");
    }
}
