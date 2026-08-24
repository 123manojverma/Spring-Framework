package com.example.crudspringbootdemo.controller;

import com.example.crudspringbootdemo.entity.Student;
import com.example.crudspringbootdemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        student.setDeleted(false);
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    //    read student
    @GetMapping("/{id}")
    public ResponseEntity<Student> readStudent(@PathVariable Long id) {
        Student student = studentService.getStudent(id);
        if (student == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> students = studentService.getAllStudents();

        if (students == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(students);
    }

    //    update student
    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestParam Long id,@RequestBody Student studentReq) {
        Student student = studentService.updateStudent(id,studentReq);
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
