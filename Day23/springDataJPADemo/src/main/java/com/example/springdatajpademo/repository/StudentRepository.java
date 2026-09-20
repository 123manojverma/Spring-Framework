package com.example.springdatajpademo.repository;

import com.example.springdatajpademo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional<Student>findByEmailLike(String pattern);

    @Query(value = """
    select * from student 
    where email=:email
""",nativeQuery = true)
    Optional<Student>findByEmail(@Param("email") String email);

    Page<Student>findByName(String name, Pageable pageable);
}

//public interface StudentRepository extends Repository<Student,Long> {
//    void save(Student student);
//
//    Optional<Student>findById(Long id);
//}

//public interface StudentRepository extends PagingAndSortingRepository<Student,Long> {
//
//}
