package com.example.IdeaAI.Service;

import com.example.IdeaAI.Dto.KeyWordsDto;
import com.example.IdeaAI.Mapper.KeyWordsMapper;
import com.example.IdeaAI.Model.KeyWords;
import com.example.IdeaAI.Repository.KeyWordsRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class KeyWordsService {

    @Autowired
    private final KeyWordsRepository keyWordsRepository;

    @Autowired
    private final KeyWordsMapper keyWordsMapper;

    public KeyWordsDto saveKeyWords(KeyWordsDto request){
        KeyWords newWord = keyWordsRepository.save(keyWordsMapper.toModel(request));

        return keyWordsMapper.toDto(newWord);
    }

    public KeyWordsDto findKeyWords(Long id){
        Optional<KeyWords> word = keyWordsRepository.findById(id);

        return keyWordsMapper.toDto(word.get());
    }

    public List<KeyWordsDto> listAllWords(){
        List<KeyWords> allWords = keyWordsRepository.findAll();

        return allWords.stream()
                .map(keyWordsMapper::toDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public KeyWordsDto editKeyWords(KeyWordsDto request, Long id){
        KeyWords model = keyWordsMapper.toModel(request);
        model.setId(id);

        KeyWords editedWord = keyWordsRepository.save(model);

        return keyWordsMapper.toDto(editedWord);
    }

    public String deleteWords(Long id){
        keyWordsRepository.deleteById(id);

        return "Palavra com id  " + id + " deletado com sucesso!";
    }
}
