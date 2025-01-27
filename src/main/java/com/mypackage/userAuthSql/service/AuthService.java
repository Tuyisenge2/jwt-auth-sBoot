package com.mypackage.userAuthSql.service;

public interface AuthService {
    String login(LoginDto loginDto);
    registerResDto Register(RegisterDto registerDto);

}