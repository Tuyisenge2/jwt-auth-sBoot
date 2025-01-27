package com.mypackage.userAuthSql.service;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mypackage.userAuthSql.model.Role;
import com.mypackage.userAuthSql.model.User;
import com.mypackage.userAuthSql.repository.RoleRepository;
import com.mypackage.userAuthSql.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    public final JwtTokenProvider jwtTokenProvider;
    
    @Autowired
    public UserRepository userRepository;

       @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository; 

    @Override
    public String login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(),
                loginDto.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        return token;
    }

    @Override
    public registerResDto Register(RegisterDto registerDto){
        User user=new User();

        if(userRepository.existsByusername(registerDto.getUsername())){
            throw new IllegalArgumentException("Username is already taken!");
            
        }
        if(userRepository.existsByemail(registerDto.getEmail()))
        {
            throw new IllegalArgumentException("Email is already taken!");
        }

        user.setId(registerDto.getId());
        user.setEmail(registerDto.getEmail());
        user.setUsername(registerDto.getUsername());
        user.setName(registerDto.getName());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
       // userRepository.save(user);

       Role defaultRole = roleRepository.findByName("ROLE_USER")
            .orElseThrow(() -> new RuntimeException("Default role 'ROLE_USER' not found"));
       user.setRoles(Set.of(defaultRole)); // Assign the single default role

    // Save the user (this creates an entry in the 'users' table and automatically in 'users_roles')
    userRepository.save(user);

      

        return new registerResDto(user.getUsername(), user.getEmail());
    }
}
