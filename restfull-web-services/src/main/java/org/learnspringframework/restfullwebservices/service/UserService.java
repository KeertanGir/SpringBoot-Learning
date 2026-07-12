package org.learnspringframework.restfullwebservices.service;

import org.learnspringframework.restfullwebservices.Exceptions.UserNotFoundException;
import org.learnspringframework.restfullwebservices.data.UserJpa;
import org.learnspringframework.restfullwebservices.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class UserService {


//    JPA/Hibernate > Database
//    we now Use Static List

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//  public list<users> findAll()
    public List<UserJpa> findAll(){
        return userRepository.findAll() ;
    }

//    public saveUser(User user)
    public UserJpa saveUser(UserJpa userJpa){
        return userRepository.save(userJpa);
    }


//    public User findOne(int id)
    public UserJpa findOne(Long id){
        Predicate<? super UserJpa> predicate = user -> user.getId() == id;
        UserJpa userJpa = userRepository.findAll().stream().filter(predicate).findFirst().orElse(null);
            if(userJpa == null){
                throw new UserNotFoundException("User not Available by this Id " + id );
            }
        return userJpa;
    }

    public void updateUser(Long id, UserJpa userJpa ){
        UserJpa oneUser = this.findOne(id);
        if(oneUser == null){
            throw new UserNotFoundException("User is Not Available by this Id : "+ id);
        }
        userRepository.save(userJpa);
    }

    public void deleteUser(Long id){
        UserJpa User = this.findOne(id);
        if(User == null){
            throw new UserNotFoundException("User is Not Available by this Id : "+ id);
        }
        userRepository.deleteById(id);
    }



}
