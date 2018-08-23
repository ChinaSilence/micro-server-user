package com.anoyi.user.service.impl;

import com.anoyi.server.rpc.user.domain.UserDTO;
import com.anoyi.user.entity.User;
import com.anoyi.user.repository.UserRepository;
import com.anoyi.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void save(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        save(user);
    }

    @Override
    public UserDTO findById(Integer id){
        User user = selectById(id);
        if (user == null){
            return null;
        }
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    @Override
    public UserDTO findByEmail(String email){
        User user = selectByEmail(email);
        if (user == null){
            return null;
        }
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    public User save(User user) {
        user.setId(null);
        if (selectByEmail(user.getEmail()) != null){
            throw new RuntimeException("user has already exist, please reset it.");
        }
        userRepository.save(user);
        return user;
    }

    public User selectById(Integer id){
        Optional<User> optional = userRepository.findById(id);
        return optional.orElse(null);
    }

    private User selectByEmail(String email){
        Optional<User> optional = userRepository.findByEmail(email);
        return optional.orElse(null);
    }

}
