package com.anoyi.user.config;

import com.anoyi.user.entity.User;
import com.anoyi.user.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final static String ROLE_TAG = "USER";

    private final UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        User user = userService.selectById(Integer.valueOf(id));
        if (user == null) {
            throw new UsernameNotFoundException("userId: " + id);
        }
        return createUserPrincipal(user);
    }

    private UserDetails createUserPrincipal(User user) {
        // 用户认证（用户名，密码，权限）
        return org.springframework.security.core.userdetails.User.builder()
                .username(String.valueOf(user.getId()))
                .password("{noop}" + user.getPassword())
                .roles(ROLE_TAG).build();
    }

}
