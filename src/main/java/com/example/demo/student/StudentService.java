package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student student = this.studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("id does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            if (this.studentRepository.findStudentByEmail(email).isPresent()) {
                throw new IllegalStateException("email is already used");
            }

            student.setEmail(email);
        }
    }
}
