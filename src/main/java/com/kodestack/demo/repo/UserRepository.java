package com.kodestack.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodestack.demo.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{

    @Query(value = "SELECT * FROM users u WHERE u.email = ?1", nativeQuery = true)
    User findOneByEmail(String email);
}
