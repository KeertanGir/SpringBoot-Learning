package com.codewithkeertan.store.Controller;

import com.codewithkeertan.store.DTOS.UserDto;
import com.codewithkeertan.store.mappers.UserMapper;
import com.codewithkeertan.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class userController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping
    public Iterable<UserDto> getAllUsers(
           @RequestParam String sort
    ){
        if(!Set.of("name", "email").contains(sort)){
            sort = "name";
        }
        return userRepository.findAll(Sort.by(sort))
                .stream()
                .map(userMapper::toDto)
                .toList();

//        .map(user -> userMapper.toDto(user)).toList();

//                .stream()
//                .map(user -> new UserDto(user.getId(), user.getName(), user.getEmail()))
//                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id){
       var user = userRepository.findById(id).orElse(null);
       if(user == null){
//           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
           return ResponseEntity.notFound().build();
       }
//        var UserDto = new UserDto(user.getId(), user.getName(), user.getEmail());
       return ResponseEntity.ok(userMapper.toDto(user));
    }
}
