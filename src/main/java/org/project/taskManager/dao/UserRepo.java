package org.project.taskManager.dao;

import org.project.taskManager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long>{
	public User findByEmail(String email);
	
	public User findByPassword(String password);
}
