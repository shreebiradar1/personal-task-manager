package org.project.taskManager.dto;

import org.project.taskManager.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserResponse {
	private int code;
	private String msg;
	
	@Autowired UserRequest request;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public UserRequest getRequest() {
		return request;
	}

	public void setRequest(User data) {
		request.setFirstName(data.getFirstName());
		request.setLastName(data.getLastName());
		request.setEmail(data.getEmail());
		request.setPassword(data.getPassword());
		request.setMobile(data.getMobile());
		
	}
	
	
}
