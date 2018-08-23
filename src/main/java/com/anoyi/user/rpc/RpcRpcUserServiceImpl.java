package com.anoyi.user.rpc;

import com.anoyi.server.rpc.user.domain.UserDTO;
import com.anoyi.server.rpc.user.service.RpcUserService;
import com.anoyi.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RpcRpcUserServiceImpl implements RpcUserService {

    private UserService userService;

    @Override
    public UserDTO getById(Integer id) {
       return userService.findById(id);
    }

}
