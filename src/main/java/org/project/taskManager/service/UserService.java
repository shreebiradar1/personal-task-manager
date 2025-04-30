package org.project.taskManager.service;

import org.project.taskManager.dao.UserRepo;
import org.project.taskManager.dto.UserRequest;
import org.project.taskManager.dto.UserResponse;
import org.project.taskManager.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired UserRepo repo;
	@Autowired UserResponse response;
	
	public UserResponse register(UserRequest user) {
		
		User userTable = new User();
		
		
		if(repo.findByEmail(user.getEmail()) != null) {
			response.setCode(501);
			response.setMsg("Email already exist");
			return response;
		}
		else {
			userTable.setFirstName(user.getFirstName());
			userTable.setLastName(user.getLastName());
			userTable.setEmail(user.getEmail());
			userTable.setPassword(user.getPassword());
			userTable.setMobile(user.getMobile());
		
		User savedData = repo.save(userTable);
		
		response.setRequest(savedData);
		response.setCode(200);
		response.setMsg("New User register");
		response.getRequest().setUserid(savedData.getUserid());
		return response;
		}
	}
	
	public UserResponse login(String email, String password) {
		//Code may change 
		User data = repo.findByEmail(email);	

		if(data == null) {
			response.setCode(404);
			response.setMsg("User may not register \n kindly please register before login");
			return response;
		}
		if(data != null && repo.findByPassword(password) != null) {
			response.setCode(200);
			response.setMsg("Login successfull");
			return response;
		}
		else {
			response.setCode(501);
			response.setMsg("Some error occured please contact to backend team");
			return response;
		}	
	}
	
}
