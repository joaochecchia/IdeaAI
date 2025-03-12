package com.example.IdeaAI.Mapper;

import com.example.IdeaAI.Dto.UsersDto;
import com.example.IdeaAI.Model.User;
import jdk.jfr.Category;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UsersDto toDto(User model){
        return new UsersDto(
                model.getId(),
                model.getEmail(),
                model.getUsername(),
                model.getPassword(),
                model.getProjects()
        );
    }

    public User toModel(UsersDto dto){
        return new User(
                dto.id(),
                dto.email(),
                dto.username(),
                dto.password(),
                dto.projects()
        );
    }
}
