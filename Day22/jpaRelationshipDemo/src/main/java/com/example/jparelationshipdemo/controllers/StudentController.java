package com.example.jparelationshipdemo.controllers;

import com.example.jparelationshipdemo.model.Student;
import com.example.jparelationshipdemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/student")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/{deptId}")
    public ResponseEntity<String> createStudent(@RequestBody Student student, @PathVariable Long deptId){
        studentService.createStudent(student,deptId);
        return ResponseEntity.ok("DONE");
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student,@RequestParam String deptName){
        studentService.createStudent(student,deptName);
        return ResponseEntity.ok("DONE");
    }

}