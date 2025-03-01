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

    // used to update data
    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id, @RequestParam(required = false) String name, @RequestParam(required = false) String email) {
        this.studentService.updateStudent(id, name, email);
    }

    // used to delete data
    @DeleteMapping(path = "{studentId}")
    public void removeStudent(@PathVariable("studentId") Long id) {
        this.studentService.deleteStudent(id);
    }
}
