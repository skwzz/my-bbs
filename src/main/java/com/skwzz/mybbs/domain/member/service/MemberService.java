package com.skwzz.mybbs.domain.member.service;

import com.skwzz.mybbs.domain.member.entity.Member;
import com.skwzz.mybbs.domain.member.entity.repository.MemberRepository;
import com.skwzz.mybbs.domain.member.mapper.MemberMapper;
import com.skwzz.mybbs.domain.member.payload.CreateMemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Transactional
    public void createMember(CreateMemberDto.Request request) {
        if(memberRepository.findByUsername(request.getUsername()) != null){
            throw new RuntimeException("이미 등록되어 있는 아이디 입니다.");
        }
        memberRepository.save(memberMapper.toEntity(request));
    }


}
