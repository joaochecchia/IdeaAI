package com.example.IdeaAI.Service;

import com.example.IdeaAI.Dto.UsersDto;
import com.example.IdeaAI.Mapper.UserMapper;
import com.example.IdeaAI.Model.User;
import com.example.IdeaAI.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    public final UserRepository userRepository;

    @Autowired
    public final UserMapper userMapper;

    public UsersDto registerUser(UsersDto request){
        User newUser = userRepository.save(userMapper.toModel(request));

        return userMapper.toDto(newUser);
    }

    public UsersDto findUserByID(Long id){
        Optional<User> findUser = userRepository.findById(id);

        return userMapper.toDto(findUser.get());
    }

    public List<UsersDto> listUser(){
        List<User> allUsers = userRepository.findAll();

        return allUsers.stream()
                .map(userMapper::toDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public UsersDto editUser(UsersDto request, Long id){
        User model = userMapper.toModel(request);
        model.setId(id);

        User editedUser = userRepository.save(model);
        return userMapper.toDto(editedUser);
    }

    public String deleteUser(Long id){
        userRepository.deleteById(id);

        return "User with id " + id + " successfully deleted.";
    }
}
