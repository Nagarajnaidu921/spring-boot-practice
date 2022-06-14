package com.kodestack.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodestack.demo.models.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
    
}
