package com.example.Student_Management_System.service;

import com.example.Student_Management_System.model.Student;
import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);

    List<Student> getAllStudent();

    Student getStudentById(long id);

    Student updateStudent(Student student, long id);

    void deleteStudent(long id);

    List<Student> getAllStudentByYearOfEnrollment(String yearOfEnrollment);

    String getDepartmentById(long id);

    void deleteAllStudentByYearOfEnrollment(String yearOfEnrollment);
}
