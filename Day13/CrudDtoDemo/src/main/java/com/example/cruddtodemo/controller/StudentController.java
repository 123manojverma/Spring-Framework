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
        if (student == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CreateStudentResponseDto>> getAllStudent() {
        List<CreateStudentResponseDto> students = studentService.getAllStudents();

        if (students == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(students);
    }

    //    update student
    @PutMapping("/update")
    public ResponseEntity<UpdateStudentResponseDto> updateStudent(@RequestParam Long id,@RequestBody UpdateStudentRequestDto studentReq) {
        UpdateStudentResponseDto student = studentService.updateStudent(id,studentReq);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

//    delete student
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        Boolean isDeleted=studentService.deleteStudent(id);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record deleted");
    }

    @PatchMapping("/delete-soft/{id}")
    public ResponseEntity<String> deleteStudentSoftly(@PathVariable Long id){
        Boolean isDeleted=studentService.deleteStudentSoftly(id);

        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Record deleted");
    }
}
