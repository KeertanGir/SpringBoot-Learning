package org.learnspringframework.jobboard.service;

import org.learnspringframework.jobboard.entities.UserPrinciples;
import org.learnspringframework.jobboard.entities.Users;
import org.learnspringframework.jobboard.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByFullName(username);
        if(users == null){
            System.out.println("User Not Found!");
            throw new UsernameNotFoundException( username + " Is Not found ");
        }

        return new UserPrinciples(users);
    }
}
