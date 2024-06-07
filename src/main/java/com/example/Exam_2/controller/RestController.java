package com.example.Exam_2.controller;


import com.example.Exam_2.enums.Post;
import com.example.Exam_2.model.Employe;
import com.example.Exam_2.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/employes")
public class RestController {

    @Autowired
    private EmployeService employeService;

    @GetMapping("/role/{role}")
    public List<Employe> getEmployesByRole(@PathVariable String role) {
        Post post;
        try {
            post = Post.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid role specified");
        }
        return employeService.getAllEmployes().stream()
                .filter(employe -> employe.getPost() == post)
                .collect(Collectors.toList());
    }
}
