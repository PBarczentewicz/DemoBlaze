package org.example.login;

import lombok.Builder;

@Builder
public class LoginRequest {

    String username;
    String password;
}
