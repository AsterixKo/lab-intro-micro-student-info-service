package com.example.lab_intro_micro_student_info_service.repositories;

import com.example.lab_intro_micro_student_info_service.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
