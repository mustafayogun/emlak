package com.piData.emlak.security.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    private String usernameOrEmail;

    private String password;
}
