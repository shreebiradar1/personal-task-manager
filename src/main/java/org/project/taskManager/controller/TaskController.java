package org.project.taskManager.controller;

import java.util.List;

import org.project.taskManager.dao.Categories;
import org.project.taskManager.dao.Process;
import org.project.taskManager.dto.TaskRequest;
import org.project.taskManager.dto.TaskResponse;
import org.project.taskManager.entity.Task;
import org.project.taskManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	TaskService service;

	@PostMapping("/addTask")
	public TaskResponse addTask(@RequestBody TaskRequest request) {
		return service.addTask(request);
	}

	@PutMapping("/editTask")
	public TaskResponse editTask(@RequestBody TaskRequest request) {
		return service.editTask(request);
	}

	@GetMapping("/filter/process/{filter}")
	public List<TaskResponse> filterByProcess(@PathVariable Process filter) {
		return service.filterByProcess(filter);
	}

	@GetMapping("/filter/category/{filter}")
	public List<TaskResponse> filterByCategory(@PathVariable Categories filter) {
		return service.filterByCategory(filter);
	}
 
	@GetMapping("/alltask")
	public List<Task> alltask() {
		return service.getAllTask();
	}

	@DeleteMapping("/delete/{id}")
	public TaskResponse deleteTask(@PathVariable Long id) {
		return service.deleteTask(id);
	}

}
