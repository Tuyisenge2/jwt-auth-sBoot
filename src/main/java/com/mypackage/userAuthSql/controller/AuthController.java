package com.mypackage.userAuthSql.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mypackage.userAuthSql.service.AuthService;
import com.mypackage.userAuthSql.service.JwtAuthResponse;
import com.mypackage.userAuthSql.service.LoginDto;
import com.mypackage.userAuthSql.service.RegisterDto;
import com.mypackage.userAuthSql.service.registerResDto;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @PostMapping("")
    public int def(){
        return 1;
    }
     @GetMapping("/login")
    public String home() {
        return "api v1 home ";
    }
    // Build Login REST API
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto){
        String token = authService.login(loginDto);

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<registerResDto> register(@RequestBody RegisterDto registerDto){
        registerResDto res = authService.Register(registerDto);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

}