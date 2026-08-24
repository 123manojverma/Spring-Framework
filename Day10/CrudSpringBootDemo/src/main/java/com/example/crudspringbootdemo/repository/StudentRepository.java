package com.example.crudspringbootdemo.repository;

import com.example.crudspringbootdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional<Student> findByIdAndDeletedIsFalse(Long id);
    List<Student> findByDeletedIsFalse();
//    findBy + fieldName + condition
}
