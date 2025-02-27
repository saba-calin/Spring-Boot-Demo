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
            Student student1 = new Student("omg", "omg@gmail.com", LocalDate.of(1989, Month.AUGUST, 18));
            Student student2 = new Student("alex", "alex@gmail.com", LocalDate.of(1990, Month.OCTOBER, 15));

            studentRepository.saveAll(List.of(student1, student2));
        };
    }
}
