package com.example.aopdemo.controller;

import com.example.aopdemo.dto.Student;
import com.example.aopdemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student s=studentService.createStudent(student);
        return ResponseEntity.ok(s);
    }

    @GetMapping
    public ResponseEntity<String>dummyMethod(){
        String s="hello";
        return ResponseEntity.ok(studentService.dummyMethod(s));
    }
}
