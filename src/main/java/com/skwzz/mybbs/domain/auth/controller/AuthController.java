package com.skwzz.mybbs.domain.auth.controller;

import com.skwzz.mybbs.domain.auth.payload.JwtDto;
import com.skwzz.mybbs.domain.auth.payload.SignInDto;
import com.skwzz.mybbs.domain.auth.service.AuthService;
import com.skwzz.mybbs.domain.member.payload.CreateMemberDto;
import com.skwzz.mybbs.domain.member.service.MemberService;
import com.skwzz.mybbs.global.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/sign-in")
    public ResponseEntity<JwtDto.Response> signIn(@RequestBody SignInDto.Request request){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        String token = jwtUtil.createToken(request.getUsername());
        return ResponseEntity.ok(JwtDto.Response.builder().accessToken(token).build());
    }


    @PostMapping("/sign-up")
    public ResponseEntity<Boolean> createMember(@RequestBody CreateMemberDto.Request request){
        authService.createMember(request);
        return ResponseEntity.ok().body(true);
    }
}
