package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // restful endpoint
    // used to get data
    @GetMapping
    public List<Student> getStudents() {
        return this.studentService.getStudents();
    }

    // used to add data
    @PostMapping
    public void addStudent(@RequestBody Student student) {
        this.studentService.addStudent(student);
    }

    // used to delete data
    @DeleteMapping(path = "{studentId}")
    public void removeStudent(@PathVariable("studentId") Long id) {
        this.studentService.deleteStudent(id);
    }
}
