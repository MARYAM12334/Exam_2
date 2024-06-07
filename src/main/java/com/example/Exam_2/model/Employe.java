package com.example.Exam_2.model;

import com.example.Exam_2.enums.Post;
import com.example.Exam_2.enums.Skills;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    @ElementCollection(targetClass = Skills.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "employe_skills")
    @Column(name = "skill")
    private List<Skills> skills;

    @Enumerated(EnumType.STRING)
    private Post post;

    @ManyToMany(mappedBy = "employees")
    private List<Project> projets = new ArrayList<>();

}
