package com.skwzz.mybbs.domain.auth.service;

import com.skwzz.mybbs.domain.member.entity.Member;
import com.skwzz.mybbs.domain.member.entity.repository.MemberRepository;
import com.skwzz.mybbs.domain.member.payload.CreateMemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUsername(username);
        if (member == null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(member.getUsername())
                .password(member.getPassword())
                .authorities("ROLE_USER")
                .build();
    }


    @Transactional
    public void createMember(CreateMemberDto.Request request) {
        if(memberRepository.findByUsername(request.getUsername()) != null){
            throw new RuntimeException("이미 등록되어 있는 아이디 입니다.");
        }
        Member member = Member.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        memberRepository.save(member);
    }
}
