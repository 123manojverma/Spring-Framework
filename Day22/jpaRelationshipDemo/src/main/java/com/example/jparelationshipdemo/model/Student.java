package com.example.jparelationshipdemo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private Department department;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;
//
//    @ManyToMany(fetch = FetchType.LAZY)
//    private List<Course> courses;

//    private void addDepartment(Department department){
//        this.department=department;
//        this.department.getStudents().add(this);
//    }
//
//    private void removeDepartment(Department department){
//        this.department=null;
//        this.department.remove(this);
//    }
}
