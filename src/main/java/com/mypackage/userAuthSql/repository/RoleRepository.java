package com.mypackage.userAuthSql.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypackage.userAuthSql.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}