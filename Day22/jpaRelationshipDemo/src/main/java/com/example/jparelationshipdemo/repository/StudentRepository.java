package com.example.jparelationshipdemo.repository;

import com.example.jparelationshipdemo.model.Student;
import jakarta.persistence.EntityGraph; // Note: Use the Jakarta import, not the Spring one
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Student student){
        entityManager.persist(student);
    }

    public Student findById(Long id){
        return entityManager.find(Student.class, id);
    }

//    @EntityGraph(attributePaths = {"department", "profile"})
    public List<Student> findAll() {
        // 1. Create a dynamic Entity Graph to fetch department and profile eagerly
        EntityGraph<Student> graph = entityManager.createEntityGraph(Student.class);
        graph.addAttributeNodes("department", "profile");

        // 2. Create the JPQL query
        String jpql = "SELECT s FROM Student s";
        TypedQuery<Student> query = entityManager.createQuery(jpql, Student.class);

        // 3. Attach the entity graph as a hint to prevent N+1 query problems
        query.setHint("jakarta.persistence.fetchgraph", graph);

        // 4. Execute and return the results
        return query.getResultList();
    }
}
