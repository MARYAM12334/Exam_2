package com.example.Exam_2.controller;

import com.example.Exam_2.model.Project;
import com.example.Exam_2.repository.ProjectRepository;
import com.example.Exam_2.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/front/teachers")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/addTeacherPage")
    public String showAddTeacherPage(Model model) {
        model.addAttribute("teacher", new Project());
        return "add-teacher";
    }

    @PostMapping("/add")
    public String addTeacher(Project project) {
        projectService.createProject(project);
        return "redirect:/front/students/all";
    }
}

