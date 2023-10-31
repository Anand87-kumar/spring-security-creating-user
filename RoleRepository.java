package com.cetpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cetpa.models.UserRole;

public interface RoleRepository extends JpaRepository<UserRole,Integer> 
{
}
