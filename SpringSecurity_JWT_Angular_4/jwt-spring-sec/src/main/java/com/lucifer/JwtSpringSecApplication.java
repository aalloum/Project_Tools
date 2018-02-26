package com.lucifer;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.lucifer.dao.TaskRepository;
import com.lucifer.entities.AppRole;
import com.lucifer.entities.AppUser;
import com.lucifer.entities.Task;
import com.lucifer.service.AccountService;

@SpringBootApplication
public class JwtSpringSecApplication implements CommandLineRunner {

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private AccountService accountService;
	
	public static void main(String[] args) {
		SpringApplication.run(JwtSpringSecApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		accountService.saveUser(new AppUser(null,"admin","1234",null));
		accountService.saveUser(new AppUser(null,"user","1234",null));
		accountService.saveRole(new AppRole(null,"ADMIN"));
		accountService.saveRole(new AppRole(null,"USER"));
		accountService.addRoleToUse("admin","ADMIN");
		accountService.addRoleToUse("admin","USER");
		accountService.addRoleToUse("user","USER");
		
		Stream.of("T1","T2","T3").forEach(t->{
			taskRepository.save( new Task(null,t) );
		});
		
		taskRepository.findAll().forEach(t->{
			System.out.println(t.getTaskName());
		});
		
	}
}
