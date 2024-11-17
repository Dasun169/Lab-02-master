package com.example.Student_Management_System.repository;

import com.example.Student_Management_System.model.Student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByYearOfEnrollment(String yearOfEnrollment);

    @Query("SELECT s.department FROM Student s WHERE s.id = :id")
    String findDepartmentById(long id);

    void deleteByYearOfEnrollment(String yearOfEnrollmet);
}
