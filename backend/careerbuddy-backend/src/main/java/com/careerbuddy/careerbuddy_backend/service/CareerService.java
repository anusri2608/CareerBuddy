package com.careerbuddy.careerbuddy_backend.service;

import org.springframework.stereotype.Service;

@Service
public class CareerService {

    public String recommendCareer(String skills, String interests) {

        String text = (skills + " " + interests).toLowerCase();

        if (text.contains("java") || text.contains("spring")) {
            return "Software Developer | Skills to Learn: Java, Spring Boot, SQL, Git, Data Structures";
        }

        if (text.contains("python") || text.contains("data")) {
            return "Data Scientist / Data Analyst | Skills to Learn: Python, SQL, Statistics, Pandas, Data Visualization";
        }

        if (text.contains("ai") || text.contains("machine learning")) {
            return "AI / ML Engineer | Skills to Learn: Python, Machine Learning, APIs, AI Fundamentals";
        }

        if (text.contains("cybersecurity") || text.contains("security")) {
            return "Cybersecurity Analyst | Skills to Learn: Networking, Linux, Security Fundamentals, Python";
        }

        if (text.contains("web") || text.contains("html")) {
            return "Full-Stack Web Developer | Skills to Learn: HTML, CSS, JavaScript, React, Spring Boot";
        }

        return "Software Developer | Skills to Learn: Java, SQL, Git, Data Structures";
    }

    public String getProjectIdea(String career) {

        if (career.contains("Software Developer")) {
            return "Build a Student Management System using Java, Spring Boot and MySQL.";
        }

        if (career.contains("Data Scientist")) {
            return "Build a Student Performance Analysis system using Python and data visualization.";
        }

        if (career.contains("AI / ML Engineer")) {
            return "Build an AI-powered Student Career Recommendation system.";
        }

        if (career.contains("Cybersecurity")) {
            return "Build a basic Network Security Monitoring Dashboard.";
        }

        if (career.contains("Full-Stack Web Developer")) {
            return "Build a Student Internship Finder web application.";
        }

        return "Build a personal portfolio website with projects and skills.";
    }

    public String getLearningRoadmap(String career) {

        if (career.contains("Software Developer")) {
            return "Month 1: Java & OOP → Month 2: SQL & Data Structures → Month 3: Spring Boot → Month 4: Git & Real-world Projects";
        }

        if (career.contains("Data Scientist")) {
            return "Month 1: Python → Month 2: Statistics & SQL → Month 3: Pandas & Data Visualization → Month 4: Machine Learning Projects";
        }

        if (career.contains("AI / ML Engineer")) {
            return "Month 1: Python → Month 2: Machine Learning Basics → Month 3: Deep Learning & APIs → Month 4: AI Projects";
        }

        if (career.contains("Cybersecurity")) {
            return "Month 1: Networking → Month 2: Linux → Month 3: Security Fundamentals → Month 4: Security Projects";
        }

        if (career.contains("Full-Stack Web Developer")) {
            return "Month 1: HTML & CSS → Month 2: JavaScript → Month 3: React & Backend → Month 4: Full-Stack Projects";
        }

        return "Month 1: Programming Basics → Month 2: SQL & Git → Month 3: Web Development → Month 4: Build Projects";
    }
}