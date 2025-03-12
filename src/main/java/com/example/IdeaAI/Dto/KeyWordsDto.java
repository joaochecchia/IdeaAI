package com.example.IdeaAI.Dto;

import com.example.IdeaAI.Model.Projects;

public record KeyWordsDto(
        Long id,
        String keyWord,
        Projects projects
) { }
