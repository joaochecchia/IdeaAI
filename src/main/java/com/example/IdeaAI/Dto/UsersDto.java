package com.example.IdeaAI.Dto;

import com.example.IdeaAI.Model.Projects;
import java.util.List;

public record UsersDto(
        Long id,
        Long email,
        String username,
        String password,
        List<Projects> projects
) { }
