package com.example.springdatajpademo.service;

import com.example.springdatajpademo.model.Student;
import com.example.springdatajpademo.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student){
        studentRepository.save(student);
    }

    public Student fetchStudentById(Long id){
        Optional<Student> studentOptional=studentRepository.findById(id);

        return studentOptional.get();
    }

    public List<Student> fetchAll(String name){
        Sort sort=Sort.by("age");
//        Sort sort=Sort.by(Sort.Direction.ASC,"age");
//        Sort sort=Sort.by("name").ascending().and(Sort.by("age").descending());

//        Pageable pageable= PageRequest.of(1,2);
        Pageable pageable= PageRequest.of(0,2,sort);

//        List<Student>studentList=studentRepository.findAll(sort);
//        Page<Student> studentList=studentRepository.findAll(pageable);
        Page<Student> studentList=studentRepository.findByName(name,pageable);

        for (Student s:studentList.getContent()){
            System.out.println(s);
        }
        return studentList.getContent();
    }

    public Student updateStudent(Student studentReq,Long id){
        Optional<Student>studentRes=studentRepository.findById(id);

        Student student=studentRes.get();

        student.setAge(studentReq.getAge());
        student.setEmail(studentReq.getEmail());
        return student;
    }
}
