package org.project.taskManager.controller;

import org.project.taskManager.dto.UserRequest;
import org.project.taskManager.dto.UserResponse;
import org.project.taskManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired UserService service;
	
	@PostMapping(path = "/register")
	public UserResponse register(@RequestBody UserRequest user) {
		return service.register(user);
	}
	
	@PostMapping(path = "/login")
	public UserResponse login(@RequestParam String email, @RequestParam String password) {
		return service.login(email, password);
	}
//	
//	@GetMapping(path = "/logout")
//	public UserResponse logout() {
//		return service.logout();
//	}
//	
}
