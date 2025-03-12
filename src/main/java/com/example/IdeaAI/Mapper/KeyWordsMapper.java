package com.example.IdeaAI.Mapper;

import com.example.IdeaAI.Dto.KeyWordsDto;
import com.example.IdeaAI.Model.KeyWords;
import org.springframework.stereotype.Component;

@Component
public class KeyWordsMapper {

    public KeyWordsDto toDto(KeyWords model){
        return new KeyWordsDto(
                model.getId(),
                model.getKeyWord(),
                model.getProjects()
        );
    }

    public KeyWords toModel(KeyWordsDto dto){
        return new KeyWords(
                dto.id(),
                dto.keyWord(),
                dto.projects()
        );
    }
}
