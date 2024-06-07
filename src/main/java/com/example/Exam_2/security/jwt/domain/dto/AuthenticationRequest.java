package com.example.Exam_2.security.jwt.domain.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String username;
    private String password;

}