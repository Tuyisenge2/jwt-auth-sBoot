package com.mypackage.userAuthSql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypackage.userAuthSql.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}