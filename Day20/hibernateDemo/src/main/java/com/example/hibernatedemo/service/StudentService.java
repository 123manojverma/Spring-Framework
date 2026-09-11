package com.example.hibernatedemo.service;

import com.example.hibernatedemo.model.Student;
import com.example.hibernatedemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return null;
    }

    @Transactional
    public Student getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Transactional
    public void updateStudent(Student studentReq,Long id) {
        Student student1=studentRepository.findById(id);

        if(student1==null){
            throw new RuntimeException("Student not found");
        }

        student1.setName(studentReq.getName());
        student1.setAge(studentReq.getAge());
        student1.setEmail(studentReq.getEmail());
    }

    @Transactional
    public void deleteStudent(Long id) {
        Student student=studentRepository.findById(id);

        if(student==null){
            throw new RuntimeException("Student not found");
        }

        studentRepository.delete(student);
    }
}
