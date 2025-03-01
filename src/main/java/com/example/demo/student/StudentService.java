package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return this.studentRepository.findAll();
    }

    public void addStudent(Student student) {
        Optional<Student> s = this.studentRepository.findStudentByEmail(student.getEmail());
        if (s.isPresent()) {
            throw new IllegalStateException("email already exists");
        }

        this.studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if (!this.studentRepository.existsById(id)) {
            throw new IllegalStateException("id does not exist");
        }

        this.studentRepository.deleteById(id);
    }
}
