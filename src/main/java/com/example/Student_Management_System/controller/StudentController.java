package com.example.Student_Management_System.controller;

import com.example.Student_Management_System.model.Student;
import com.example.Student_Management_System.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentId) {
        return new ResponseEntity<Student>(studentService.getStudentById(studentId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Employee deleted successfully.", HttpStatus.OK);
    }

    @DeleteMapping("/YearOfEnrollment/{yearOfEnrollment}")
    public ResponseEntity<String> deleteAllStudentByYearOfEnrollment(@PathVariable("yearOfEnrollment") String yearOfEnrollment) {
        System.out.println("Received yearOfEnrollment: " + yearOfEnrollment); // Debugging log
        studentService.deleteAllStudentByYearOfEnrollment(yearOfEnrollment);
        return new ResponseEntity<String>("Employee deleted successfully.", HttpStatus.OK);
    }

    @GetMapping("/yearOfEnrollment/{yearOfEnrollment}")
    public ResponseEntity<List<Student>> getAllStudentByYearOfEnrollment(@PathVariable("yearOfEnrollment") String yearOfEnrollment) {
        List<Student> students = studentService.getAllStudentByYearOfEnrollment(yearOfEnrollment);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<String> getDepartmentById(@PathVariable("id") long id) {
        String departmentName = studentService.getDepartmentById(id);
        return new ResponseEntity<>(departmentName,HttpStatus.OK);
    }
}
