package com.anoyi.server.api.user.service;

import com.anoyi.grpc.annotation.GrpcService;
import com.anoyi.server.api.user.domain.UserDTO;

@GrpcService(server = "micro-server-user")
public interface UserService {

    void save(UserDTO userDTO);

    UserDTO findById(Integer id);

    UserDTO findByEmail(String email);

}
