package com.example.Exam_2.security.jwt.domain.dto;

import lombok.Data;

@Data

public class AuthenticationResponse {
    private final String jwt;
}