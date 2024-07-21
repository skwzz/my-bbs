package com.skwzz.mybbs.domain.auth.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtDto {

    @Getter
    @Setter
    @Builder
    public static class Response{
        private String accessToken;
        private String refreshToken;
    }
}
