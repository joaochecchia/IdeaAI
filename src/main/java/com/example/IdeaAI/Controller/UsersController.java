package com.example.IdeaAI.Controller;

import com.example.IdeaAI.Dto.UsersDto;
import com.example.IdeaAI.Mapper.UserMapper;
import com.example.IdeaAI.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ideaAi/projects")
@RequiredArgsConstructor
public class UsersController {

    @Autowired
    private final UserService userService;

    @Autowired
    private final UserMapper userMapper;


    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> saveUser(@RequestBody UsersDto request){
        UsersDto newUser = userService.registerUser(request);

        Map<String, Object> response = new HashMap();;
        response.put("Message: ", "User successfully signed.");
        response.put("Body: ", newUser);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Map<String, Object>> findUser(@PathVariable Long id){
        UsersDto user = userService.findUserByID(id);

        Map<String, Object> response = new HashMap();;
        response.put("Message: ", "User successfully found");
        response.put("Body: ", user);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Map<String, Object>> listUsers(){
        List<UsersDto> users = userService.listUser();

        Map<String, Object> response = new HashMap();;
        response.put("Message: ", "Users successfully listed.");
        response.put("Body: ", users);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Map<String, Object>> editUsers(@RequestBody UsersDto editRequest, @PathVariable Long id){
        UsersDto editedUserr = userService.editUser(editRequest, id);

        Map<String, Object> response = new HashMap();;
        response.put("Message: ", "User successfully edited.");
        response.put("Body: ", editedUserr);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteList(@PathVariable Long id){
        String deletionResponse = userService.deleteUser(id);

        Map<String, Object> response = new HashMap();;
        response.put("Message: ", deletionResponse);

        return ResponseEntity.ok(response);
    }
}
