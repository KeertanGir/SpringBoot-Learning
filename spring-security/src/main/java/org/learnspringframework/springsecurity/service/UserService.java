package org.learnspringframework.springsecurity.service;

import org.learnspringframework.springsecurity.model.Users;
import org.learnspringframework.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }




    public Users register(Users users){
        users.setPassword(passwordEncoder.encode(users.getPassword()));
       return userRepository.save(users);
    }


    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }
}
