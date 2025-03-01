package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student student1 = Student.builder().name("omg").email("omg@gmail.com").dob(LocalDate.of(1989, Month.AUGUST, 18)).build();
            Student student2 = Student.builder().name("alex").email("alex@gmail.com").dob(LocalDate.of(1990, Month.OCTOBER, 18)).build();

            studentRepository.saveAll(List.of(student1, student2));
        };
    }
}
