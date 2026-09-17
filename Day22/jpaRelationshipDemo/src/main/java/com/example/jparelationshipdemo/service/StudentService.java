package com.example.jparelationshipdemo.service;

import com.example.jparelationshipdemo.model.Department;
import com.example.jparelationshipdemo.model.Profile;
import com.example.jparelationshipdemo.model.Student;
import com.example.jparelationshipdemo.repository.DepartmentRepository;
import com.example.jparelationshipdemo.repository.ProfileRepository;
import com.example.jparelationshipdemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository;

    DepartmentRepository departmentRepository;

    ProfileRepository profileRepository;

    public StudentService(StudentRepository studentRepository,DepartmentRepository departmentRepository,ProfileRepository profileRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository=departmentRepository;
        this.profileRepository=profileRepository;
    }

//    @Transactional
//    public void createStudent(Student student,Long deptId){
//        Department department=departmentRepository.getDepartmentById(deptId);
//        student.setDepartment(department);
//        department.getStudents().add(student);
//        studentRepository.save(student);
//    }
//
//    @Transactional
//    public void createStudent(Student student,String deptName){
//        Department department=new Department();
//        department.setName(deptName);
//
//        department.getStudents().add(student);
//        student.setDepartment(department);
//
//        departmentRepository.save(department);
//        studentRepository.save(student);
//    }

    @Transactional
    public void createStudent(Student student){
        Department department=new Department();
        department.setName("CSE");

        Profile profile=new Profile();
        profile.setBio("Simple Bio");

        student.setDepartment(department);
        student.setProfile(profile);

        departmentRepository.save(department);
        profileRepository.save(profile);
        studentRepository.save(student);
    }

    public Student fetchStudentId(Long id){
        Student s1= studentRepository.findById(id);

        System.out.println("Lazily fetched Student");

        Department d1=s1.getDepartment();

        System.out.println("Lazily fetched Department");

        Profile p1=s1.getProfile();

        System.out.println("Lazily fetched Profile");

        return s1;
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }
}
