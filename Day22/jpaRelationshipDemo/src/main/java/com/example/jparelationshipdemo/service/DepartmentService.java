package com.example.jparelationshipdemo.service;

import com.example.jparelationshipdemo.model.Department;
import com.example.jparelationshipdemo.model.Student;
import com.example.jparelationshipdemo.repository.DepartmentRepository;
import com.example.jparelationshipdemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    DepartmentRepository departmentRepository;
    StudentRepository studentRepository;
    public DepartmentService(DepartmentRepository departmentRepository,StudentRepository studentRepository) {
        this.departmentRepository = departmentRepository;
        this.studentRepository=studentRepository;
    }

//    @Transactional
//    public void createDepartment(Department department){
//        Student s1=new Student();
//        s1.setName("Aditya");
//        s1.setDepartment(department);
//
//        Student s2=new Student();
//        s2.setName("Rohan");
//        s2.setDepartment(department);
//
//        Student s3=new Student();
//        s3.setName("Karan");
//        s3.setDepartment(department);
//
//        Student s4=new Student();
//        s4.setName("Rohit");
//        s4.setDepartment(department);
//
//        department.getStudents().addAll(List.of(s1,s2,s3,s4));
//
//        departmentRepository.save(department);
//    }

//    @Transactional
//    public void createDepartment(Department department,String studentName
//    ){
//        Student student=new Student();
//        student.setName(studentName);
//        student.setDepartment(department);
//
//        department.getStudents().add(student);
//        departmentRepository.save(department);
//        studentRepository.save(student);
//    }

    @Transactional
    public void removeDepartment(Long id){
        Department department=departmentRepository.getDepartmentById(id);
        departmentRepository.removeDepartment(department);
    }
}
