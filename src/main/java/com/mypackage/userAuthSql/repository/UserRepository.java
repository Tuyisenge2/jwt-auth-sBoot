package com.mypackage.userAuthSql.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypackage.userAuthSql.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsernameOrEmail(String username, String email);
}

