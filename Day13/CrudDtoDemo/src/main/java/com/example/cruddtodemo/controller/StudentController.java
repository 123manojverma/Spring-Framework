package com.example.cruddtodemo.controller;

import com.example.cruddtodemo.dto.CreateStudentRequestDto;
import com.example.cruddtodemo.dto.CreateStudentResponseDto;
import com.example.cruddtodemo.dto.UpdateStudentRequestDto;
import com.example.cruddtodemo.dto.UpdateStudentResponseDto;
import com.example.cruddtodemo.entity.Student;
import com.example.cruddtodemo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//validations -> spring-boot-starter-validation

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<CreateStudentResponseDto> createStudent(@Valid @RequestBody CreateStudentRequestDto student) {
        CreateStudentResponseDto createdStudent = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }


    //    read student
    @GetMapping("/{id}")
    public ResponseEntity<CreateStudentResponseDto> readStudent(@PathVariable Long id) {
        CreateStudentResponseDto student = studentService.getStudent(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<List<CreateStudentResponseDto>> getAllStudent() {
        List<CreateStudentResponseDto> students = studentService.getAllStudents();

        if (students == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(students);
    }

    //    update student
    @PutMapping
    public ResponseEntity<UpdateStudentResponseDto> updateStudent(@RequestParam Long id,@RequestBody UpdateStudentRequestDto studentReq) {
        UpdateStudentResponseDto student = studentService.updateStudent(id,studentReq);

        return ResponseEntity.ok(student);
    }

//    delete student
    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping
    public ResponseEntity<String> deleteStudentSoftly(@RequestParam Long id){
        studentService.deleteStudentSoftly(id);

        return ResponseEntity.noContent().build();
    }
}
