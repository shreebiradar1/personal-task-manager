package org.project.taskManager.entity;

import java.time.LocalDate;

import org.project.taskManager.dao.Categories;
import org.project.taskManager.dao.Process;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskid;
	private String tasktitle;
	@Enumerated(EnumType.STRING)
	private Process status;
	@Enumerated(EnumType.STRING)
	private Categories category;
	private LocalDate deadline;

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public Long getTaskid() {
		return taskid;
	}

	public void setTaskid(Long taskid) {
		this.taskid = taskid;
	}

	public String getTasktitle() {
		return tasktitle;
	}

	public void setTasktitle(String tasktitle) {
		this.tasktitle = tasktitle;
	}

	public Process getStatus() {
		return status;
	}

	public void setStatus(Process status) {
		this.status = status;
	}

}
