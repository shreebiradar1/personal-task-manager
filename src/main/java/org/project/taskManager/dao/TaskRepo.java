package org.project.taskManager.dao;

import java.util.List;

import org.project.taskManager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long>{
	public List<Task> findByStatus(Process status); 
	
	public List<Task> findByCategory(Categories category);
}
