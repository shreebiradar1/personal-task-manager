package org.project.taskManager.dto;

import org.project.taskManager.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskResponse {
	private int code;
	private String msg;
	
	@Autowired
	private TaskRequest req;

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

	public TaskRequest getRequest() {
		return req;
	}

	public void setRequest(TaskRequest req) {
		this.req = req;
	}

	public void setRequest(Task task) {
		task.setTasktitle(req.getTitle());
		task.setStatus(req.getStatus());
		task.setCategory(req.getCategory());
		task.setDeadline(req.getDeadline());
		
	}
	
	
	
}
