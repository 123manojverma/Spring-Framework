package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.example.model.Student;
import com.example.repository.StudentRepository;
import io.github.cdimascio.dotenv.Dotenv;

public class Main {
    public static void main(String[] args) {

        StudentRepository studentRepository = new StudentRepository();

//        studentRepository.createStudent(new Student("Rohan","rohan@gmail.com",26));
//        studentRepository.updateStudent(new Student("Aman Kumar","aman@gmail.com",28), 4L);
//        studentRepository.deleteStudent(5L);
        studentRepository.getStudentById(4L);
    }
}