package com.example.crudspringbootdemo.repository;

import com.example.crudspringbootdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
