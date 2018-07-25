package com.anoyi.server.api.user.domain;

import lombok.Data;

@Data
public class UserDTO {

    private Integer id;

    private String email;

    private String password;

    private String nickname;

    private String avatar;

}
