package com.careerbuddy.careerbuddy_backend.controller;

import com.careerbuddy.careerbuddy_backend.model.Student;
import com.careerbuddy.careerbuddy_backend.repository.StudentRepository;
import com.careerbuddy.careerbuddy_backend.service.CareerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/students")
public class CareerController {

    private final StudentRepository studentRepository;
    private final CareerService careerService;

    public CareerController(
            StudentRepository studentRepository,
            CareerService careerService) {

        this.studentRepository = studentRepository;
        this.careerService = careerService;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @PostMapping("/recommend")
    public String recommendCareer(@RequestBody Student student) {
        return careerService.recommendCareer(
                student.getSkills(),
                student.getInterests()
        );
    }

    @PostMapping("/project")
    public String getProjectIdea(@RequestBody Student student) {

        String career = careerService.recommendCareer(
                student.getSkills(),
                student.getInterests()
        );

        return careerService.getProjectIdea(career);
    }

    @PostMapping("/roadmap")
    public String getLearningRoadmap(@RequestBody Student student) {

        String career = careerService.recommendCareer(
                student.getSkills(),
                student.getInterests()
        );

        return careerService.getLearningRoadmap(career);
    }
}