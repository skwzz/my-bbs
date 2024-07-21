package com.skwzz.mybbs.domain.member.service;

import com.skwzz.mybbs.domain.member.entity.repository.MemberRepository;
import com.skwzz.mybbs.domain.member.mapper.MemberMapper;
import com.skwzz.mybbs.domain.member.payload.CreateMemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public void createMember(CreateMemberDto.Request request) {
        memberRepository.save(memberMapper.toEntity(request));
    }
}
