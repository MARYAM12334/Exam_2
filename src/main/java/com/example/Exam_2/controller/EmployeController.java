package com.example.Exam_2.controller;

import com.example.Exam_2.model.Employe;
import com.example.Exam_2.service.EmployeService;
import com.example.Exam_2.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/front/students")
public class EmployeController {
    @Autowired
    EmployeService employeService;
    @Autowired
    ProjectService projectService;

    public EmployeController(EmployeService studentService) {
        this.employeService = studentService;
    }


    @GetMapping("/all")
    public String listStudent(Model model) {
        List<Employe> employes = employeService.getAllEmployes();
        model.addAttribute("employes", employes);
        return "listEmploye";
    }



//    @PostMapping("/save")
//    public String saveStudent(Student student) {
//        studentService.addStudent(student);
//        return "redirect:/front/students/all";
//    }

    @GetMapping("/addStudentPage")
    public String getaddStudentPage(Model model) {
        model.addAttribute("student", new Employe());
        model.addAttribute("teachers", projectService.getAllProjects());
        return "addEmploye";
    }

    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute("student") Employe student,
                             @RequestParam(value = "teacherIds",
                                     required = false) List<Long> teacherIds) {
//        if(teacherIds != null) {
//            List<Project> projects = projectService.getAllTeachers()
//                    .stream()
//                    .filter(teacher -> teacherIds.contains(teacher.getId()))
//                    .collect(Collectors.toList());
//            student.setProjets(projects);
//        }

        employeService.addEmploye(student);
        return "redirect:/front/students/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        employeService.deleteEmploye(id);
        return "redirect:/front/students/all";
    }

}
