package org.learnspringframework.springsecurity.service;

import org.learnspringframework.springsecurity.model.UserPrinciples;
import org.learnspringframework.springsecurity.model.Users;
import org.learnspringframework.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;


    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users byUsername = userRepository.findByUsername(username);
        if(byUsername == null){
            System.out.println("User Not Found!");
            throw new UsernameNotFoundException( username + " Is Not found ");
        }
        return new UserPrinciples(byUsername);
    }
}
