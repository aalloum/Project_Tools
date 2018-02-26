package com.lucifer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucifer.entities.AppRole;

public interface RoleRepository extends JpaRepository< AppRole , Long >{

	public AppRole findByRoleName(String roleName);
}
