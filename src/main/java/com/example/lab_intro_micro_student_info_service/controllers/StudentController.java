package com.example.lab_intro_micro_student_info_service.controllers;

import com.example.lab_intro_micro_student_info_service.models.Student;
import com.example.lab_intro_micro_student_info_service.repositories.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            Optional<Student> studentOptional = studentRepository.findById(id);

            if (studentOptional.isPresent()) {
                return new ResponseEntity<>(studentOptional.get(), HttpStatus.FOUND);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error obteniendo student", HttpStatus.BAD_REQUEST);
        }
    }
}
