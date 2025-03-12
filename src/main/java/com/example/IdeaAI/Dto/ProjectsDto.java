package com.example.IdeaAI.Dto;

import com.example.IdeaAI.Model.KeyWords;
import com.example.IdeaAI.Model.User;
import jakarta.persistence.*;

import java.util.List;

public record ProjectsDto(
         Long id,
         byte[] image,
         String description,
         User user,
         List<KeyWords> keyWords
) { }
