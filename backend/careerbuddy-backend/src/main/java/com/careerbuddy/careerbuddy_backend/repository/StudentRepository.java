package com.careerbuddy.careerbuddy_backend.repository;

import com.careerbuddy.careerbuddy_backend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}