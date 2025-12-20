package com.deepak.User_Management_System.repository;

import com.deepak.User_Management_System.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {
}
