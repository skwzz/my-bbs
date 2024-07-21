package com.skwzz.mybbs.domain.auth.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInDto {

    @Getter
    @Setter
    public static class Request{
        private String username;
        private String password;
    }
}
