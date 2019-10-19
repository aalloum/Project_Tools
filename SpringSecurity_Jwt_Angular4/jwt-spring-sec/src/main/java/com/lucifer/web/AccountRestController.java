package com.lucifer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lucifer.entities.AppUser;
import com.lucifer.service.AccountService;

@RestController
public class AccountRestController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping("/register")
	public AppUser register(@RequestBody RegisterForm userForm) {
		if(!userForm.getPassword().equals(userForm.getRepassword()))
			throw new RuntimeException("You must confirm your password");
		AppUser user=accountService.findUserByUsername(userForm.getPassword());
		if(user!=null) throw new RuntimeException("This user already exits");
		AppUser appUser=new AppUser();
		appUser.setUsername(userForm.getUsername());
		appUser.setPassword(userForm.getPassword());		
		accountService.saveUser(appUser);
		accountService.saveUser(appUser);
		accountService.addRoleToUse(userForm.getUsername(), "USER");
		return appUser;
	}
}
