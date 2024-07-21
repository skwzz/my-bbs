package com.skwzz.mybbs.domain.member.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMemberDto {

    @Getter
    @Setter
    public static class Request{
        private String username;
        private String password;
    }
}
