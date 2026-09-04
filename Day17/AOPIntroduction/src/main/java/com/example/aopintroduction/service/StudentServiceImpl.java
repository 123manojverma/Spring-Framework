package com.example.aopintroduction.service;

import com.example.aopintroduction.dto.Student;
import com.example.aopintroduction.repository.StudentRepository;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void createStudent(Student student){
//        LoggingServiceUtil.logStart("StudentService","createStudent");

        try {
            Thread.sleep(2000);
        }catch (Exception e){}

        studentRepository.save(student);

//        LoggingServiceUtil.logEnd("StudentService","createStudent");

    }
}
