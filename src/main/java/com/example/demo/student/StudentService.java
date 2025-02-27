package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents() {
        return List.of(
            new Student(1, "omg", "omg@gmail.com", LocalDate.of(1989, Month.AUGUST, 18), 46)
        );
    }
}
