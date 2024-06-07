package com.example.Exam_2.controller;

import com.example.Exam_2.model.Employe;
import com.example.Exam_2.model.Project;
import com.example.Exam_2.service.EmployeService;
import com.example.Exam_2.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AffectationController {

    @Autowired
    private EmployeService employeService;

    @Autowired
    private ProjectService projetService;

    @GetMapping("/affectation")
    public String showAffectationForm(Model model) {
        List<Employe> employes = employeService.getAllEmployes();
        model.addAttribute("employes", employes);
        return "affectation";
    }

    @PostMapping("/affectation")
    public String affecterEmploye(@RequestParam Long employeId, @RequestParam String projetName, @RequestParam int implication) {
        Employe employe = employeService.getEmployeById(employeId);
        Project projet = projetService.findByName(projetName);
        if (projet == null) {
            projet = new Project();
            projet.setName(projetName);
            projetService.saveProjet(projet);
        }
        if (employe != null && implication >= 10 && implication <= 100) {
            employe.getProjets().add(projet);
            // Assuming you have a method to handle implication percentage.
            employeService.saveEmploye(employe);
        }
        return "affectation";
    }
}