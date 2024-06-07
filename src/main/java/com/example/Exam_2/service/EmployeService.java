package com.example.Exam_2.service;


import com.example.Exam_2.model.Employe;
import com.example.Exam_2.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EmployeService {

    @Autowired
    EmployeRepository employeRepository;


    public EmployeService(EmployeRepository studentRepository) {
        this.employeRepository = studentRepository;
    }

    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    public Employe getEmployeById(Long id) {
        return employeRepository.findById(id).orElse(null);
    }
    public Employe addEmploye(Employe student) {
        return employeRepository.save(student);
    }
    public Employe updateEmploye(Employe student) {
        return employeRepository.save(student);
    }
    public void deleteEmploye(Long id) {
        employeRepository.deleteById(id);
    }

    public void saveEmploye(Employe employe) {
        employeRepository.save(employe);
    }
}
