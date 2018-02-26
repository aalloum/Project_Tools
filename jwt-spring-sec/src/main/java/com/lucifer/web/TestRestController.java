package com.lucifer.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lucifer.dao.TaskRepository;
import com.lucifer.entities.Task;

@RestController
public class TestRestController {

	@Autowired
	private TaskRepository taskRepository;
	
	@GetMapping("/tasks")
	public List<Task> listTasks(){
		return taskRepository.findAll();
	}
	
	@PostMapping("tasks")
	public Task save(@RequestBody Task t){
		return taskRepository.save(t);
	}
}
