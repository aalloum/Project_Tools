package com.lucifer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucifer.entities.AppUser;

public interface UserRepository extends JpaRepository< AppUser, Long>{

	public AppUser findByUsername(String username);
}
