package com.example.IdeaAI.Mapper;

import com.example.IdeaAI.Dto.ProjectsDto;
import com.example.IdeaAI.Model.Projects;
import org.springframework.stereotype.Component;

@Component
public class ProjectsMapper {

    public ProjectsDto toDto(Projects model){
        return new ProjectsDto(
                model.getId(),
                model.getImage(),
                model.getDescription(),
                model.getUser(),
                model.getKeyWords()
        );
    }

    public Projects toModel(ProjectsDto dto){
        return new Projects(
                dto.id(),
                dto.image(),
                dto.description(),
                dto.user(),
                dto.keyWords()
        );
    }
}
