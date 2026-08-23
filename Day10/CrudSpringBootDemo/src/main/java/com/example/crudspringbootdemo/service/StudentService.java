package com.example.crudspringbootdemo.service;

import com.example.crudspringbootdemo.entity.Student;
import com.example.crudspringbootdemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public Student createStudent(Student studentReq){
        Student studentRes=studentRepository.save(studentReq);
        return studentRes;
    }

    public Student getStudent(Long id){
        Optional<Student> student=studentRepository.findById(id);
        return student.orElse(null);
    }

    public List<Student> getAllStudents(){
        List<Student>students=studentRepository.findAll();
        return students;
    }

    public Student updateStudent(Long id,Student studentReq){
        Optional<Student> studentRes= studentRepository.findById(id);
        if(studentRes.isEmpty()){
            return null;
        }

        Student studentToSave=studentRes.get();
        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());
        return studentRepository.save(studentToSave);
    }

    public Boolean deleteStudent(Long id){
        boolean isStudent= studentRepository.existsById(id);
        if(!isStudent){
            return false;
        }

        studentRepository.deleteById(id);
        return true;
    }
}
