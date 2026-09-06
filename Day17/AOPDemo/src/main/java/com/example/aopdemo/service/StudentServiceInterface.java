package com.example.aopdemo.service;

import com.example.aopdemo.dto.Student;

public interface StudentServiceInterface {
    Student createStudent(Student student);
    String getStudent(String s);
}
