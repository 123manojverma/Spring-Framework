package com.example.hibernatedemo.repository;

import com.example.hibernatedemo.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

//    create
    public void save(Student student){
        entityManager.persist(student);
    }

//    read
    public Student findById(Long id){
        return entityManager.find(Student.class,id);
    }

//    delete
    public void delete(Student student){
        entityManager.remove(student);
    }
}