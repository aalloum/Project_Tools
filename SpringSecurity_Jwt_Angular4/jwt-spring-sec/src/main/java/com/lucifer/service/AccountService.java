package com.lucifer.service;

import com.lucifer.entities.AppRole;
import com.lucifer.entities.AppUser;

public interface AccountService {

	public AppUser saveUser(AppUser user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUse(String username, String roleName);
	public AppUser findUserByUsername(String username);
}
