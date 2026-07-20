package org.learnspringframework.jobboard.service;

import jakarta.validation.Valid;
import org.learnspringframework.jobboard.dtos.UsersRequestDto;
import org.learnspringframework.jobboard.dtos.UsersResponseDto;
import org.learnspringframework.jobboard.entities.Users;
import org.learnspringframework.jobboard.exceptions.DuplicateEmailException;
import org.learnspringframework.jobboard.exceptions.UserNotFoundException;
import org.learnspringframework.jobboard.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Users createUser(UsersRequestDto usersRequestDto) {
        boolean exists = userRepository.existsByEmailIs(usersRequestDto.getEmail());
        if(exists){
            throw new DuplicateEmailException("this Email "+ usersRequestDto.getEmail() +"  Already Exits, try new Email");
        }
        Users users = mapToEntity(usersRequestDto);
        userRepository.save(users);

        return users;
    }

    Users mapToEntity(UsersRequestDto usersRequestDto){
        return new Users(
                usersRequestDto.getFullName(),
                usersRequestDto.getEmail(),
                usersRequestDto.getPassword(),
                usersRequestDto.getRole(),
                usersRequestDto.getCreatedAt()
        );
    }

    UsersResponseDto mapToDto (Users users){
        return new UsersResponseDto(
                users.getId(),
                users.getFullName(),
                users.getEmail(),
                users.getRole(),
                users.getCreatedAt(),
                users.getPostedJobs().size(),
                users.getApplications().size()
        );
    }


    public void updateUser(Long id, @Valid UsersRequestDto usersRequestDto) {
        Users useByid = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User id Not Found By id : " + id));
        if(!useByid.getEmail().equals(usersRequestDto.getEmail())){
            boolean exists = userRepository.existsByEmailIs(usersRequestDto.getEmail());
            if(exists){
                throw new DuplicateEmailException("this Email "+ usersRequestDto.getEmail() +"  Already Exits, try new Email");
            }
        }
        useByid.setFullName(usersRequestDto.getFullName());
        useByid.setEmail(usersRequestDto.getEmail());
        useByid.setRole(usersRequestDto.getRole());
        useByid.setPassword(usersRequestDto.getPassword());
        userRepository.save(useByid);
    }

    public UsersResponseDto getUserById(Long id) {
        Users users = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User id Not Found By id : " + id));
       return   mapToDto(users);
    }

    public List<UsersResponseDto> getAllUsers() {
        return userRepository.findAll().stream().map(this::mapToDto).toList();
    }

    public void deleteUserById(Long id) {
        Users users = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User id Not Found By id : " + id));
        userRepository.deleteById(id);
    }
}
