package com.skwzz.mybbs.domain.member.mapper;

import com.skwzz.mybbs.domain.member.entity.Member;
import com.skwzz.mybbs.domain.member.payload.CreateMemberDto;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public Member toEntity(CreateMemberDto.Request request){
        return Member.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .build();
    }
}
