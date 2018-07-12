package com.anoyi.user.service;

import com.anoyi.user.entity.User;
import com.anoyi.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(User user){
        user.setId(null);
        if (findByName(user.getName()) != null){
            throw new RuntimeException("username has already exist, please reset it.");
        }
        userRepository.save(user);
        return user;
    }

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Integer id){
        Optional<User> optional = userRepository.findById(id);
        return optional.orElse(null);
    }

    public User findByName(String name){
        Optional<User> optional = userRepository.findByName(name);
        return optional.orElse(null);
    }

}
