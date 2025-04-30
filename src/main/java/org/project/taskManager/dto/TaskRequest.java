package org.project.taskManager.dto;

import java.time.LocalDate;

import org.project.taskManager.dao.Categories;
import org.project.taskManager.dao.Process;
import org.springframework.stereotype.Component;

@Component
public class TaskRequest {
	private Long taskid;
	private String title;
	private Process status = Process.NOTSTARTED;
	private LocalDate deadline;
	private Categories category;

	public Long getTaskid() {
		return taskid;
	}

	public void setTaskid(Long taskid) {
		this.taskid = taskid;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Process getStatus() {
		return status;
	}

	public void setStatus(Process status) {
		this.status = status;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

}
