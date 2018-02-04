package com.therealdanvega.tech.controller;

import com.therealdanvega.tech.domain.Student;
import com.therealdanvega.tech.domain.StudentRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RequestMapping("/")
    public List<Student> list() {
        return studentRepository.findAll();
    }

}
