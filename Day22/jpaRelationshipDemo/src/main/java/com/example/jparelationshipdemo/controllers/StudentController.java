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

//    @PostMapping("/{deptId}")
//    public ResponseEntity<String> createStudent(@RequestBody Student student, @PathVariable Long deptId){
//        studentService.createStudent(student,deptId);
//        return ResponseEntity.ok("DONE");
//    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return ResponseEntity.ok("DONE");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student student=studentService.fetchStudentId(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>>getAllStudents(){
        List<Student>students=studentService.findAll();
        return ResponseEntity.ok(students);
    }

}