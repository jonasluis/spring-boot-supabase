package com.jonas.supabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonas.supabase.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
