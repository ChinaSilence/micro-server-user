package com.anoyi.user.service;

import com.anoyi.server.rpc.user.domain.UserDTO;

public interface UserService {

    void save(UserDTO userDTO);

    UserDTO findById(Integer id);

    UserDTO findByEmail(String email);

}
