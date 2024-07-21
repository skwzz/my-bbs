package com.skwzz.mybbs.domain.member.controller;

import com.skwzz.mybbs.domain.member.payload.CreateMemberDto;
import com.skwzz.mybbs.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Boolean> createMember(@RequestBody CreateMemberDto.Request request){
        memberService.createMember(request);
        return ResponseEntity.ok().body(true);
    }
}
