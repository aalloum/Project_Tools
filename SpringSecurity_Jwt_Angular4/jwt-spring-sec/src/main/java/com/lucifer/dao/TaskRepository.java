package com.lucifer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucifer.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long >{

	
}
