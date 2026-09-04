package com.example.aopintroduction.service;

import com.example.aopintroduction.dto.Student;
import com.example.aopintroduction.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    void createStudent(Student student);
}
