package com.mypackage.userAuthSql.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    
}
