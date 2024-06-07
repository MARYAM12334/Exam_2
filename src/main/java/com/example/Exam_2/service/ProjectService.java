package com.example.Exam_2.service;


import com.example.Exam_2.model.Project;
import com.example.Exam_2.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project createProject(Project teacher) {
        return projectRepository.save(teacher);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    // Update operation
    public Project updateProject(Long id, Project newTeacher) {
        Optional<Project> existingTeacherOptional = projectRepository.findById(id);
        if (existingTeacherOptional.isPresent()) {
            Project existingTeacher = existingTeacherOptional.get();
            // Update the properties of existingTeacher with newTeacher
            existingTeacher.setName(newTeacher.getName());
            // Update other properties as needed
            return projectRepository.save(existingTeacher);
        } else {
            // Handle error if teacher with given id is not found
            return null;
        }
    }

    // Delete operation
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
