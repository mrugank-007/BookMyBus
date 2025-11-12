package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AdminLogin;

@Repository
public interface AdminLoginRepo extends JpaRepository<AdminLogin, Integer> {

}
