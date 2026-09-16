package com.example.jparelationshipdemo.service;

import com.example.jparelationshipdemo.model.Department;
import com.example.jparelationshipdemo.model.Student;
import com.example.jparelationshipdemo.repository.DepartmentRepository;
import com.example.jparelationshipdemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository;

    DepartmentRepository departmentRepository;

    public StudentService(StudentRepository studentRepository,DepartmentRepository departmentRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository=departmentRepository;
    }

    @Transactional
    public void createStudent(Student student,Long deptId){
        Department department=departmentRepository.getDepartmentById(deptId);
        student.setDepartment(department);
        department.getStudents().add(student);
        studentRepository.save(student);
    }

    @Transactional
    public void createStudent(Student student,String deptName){
        Department department=new Department();
        department.setName(deptName);

        department.getStudents().add(student);
        student.setDepartment(department);

        departmentRepository.save(department);
        studentRepository.save(student);
    }
}
