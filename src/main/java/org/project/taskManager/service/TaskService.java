package org.project.taskManager.service;

import java.util.ArrayList;

import java.util.List;

import org.project.taskManager.dao.Categories;
import org.project.taskManager.dao.Process;
import org.project.taskManager.dao.TaskRepo;
import org.project.taskManager.dto.TaskRequest;
import org.project.taskManager.dto.TaskResponse;
import org.project.taskManager.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

	@Autowired
	TaskRepo repo;
	@Autowired
	TaskResponse resp;

	public TaskResponse addTask(TaskRequest request) {
		Task task = new Task();
		task.setTasktitle(request.getTitle());
		task.setStatus(request.getStatus());
		task.setCategory(request.getCategory());
		task.setDeadline(request.getDeadline());
		resp.setRequest(task);
		resp.getRequest().setTaskid(task.getTaskid());
		resp.setCode(200);
		resp.setMsg("New Task Added");

		repo.save(task);
		return resp;

	}

	public TaskResponse editTask(TaskRequest req) {
		Task task = new Task();
		task.setTaskid(req.getTaskid());
		task.setTasktitle(req.getTitle());
		task.setStatus(req.getStatus());
		task.setCategory(req.getCategory());
		task.setDeadline(req.getDeadline());
		resp.setCode(200);
		resp.setMsg("Task Updated");
		repo.save(task);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public List<TaskResponse> filterByProcess(Process filter) {

		List<TaskResponse> response = new ArrayList<>();

		if (filter.equals(Process.NOTSTARTED)) {

			List<Task> notCompletedTask = repo.findByStatus(Process.NOTSTARTED);

			for (Task task : notCompletedTask) {
				resp.setCode(200);
				resp.setMsg("This is all Not completed Task");
				resp.setRequest(task);
				response.add(resp);
			}
			return response;

		} else if (filter.equals(Process.STARTED)) {
			
			List<Task> StartedTask = repo.findByStatus(Process.STARTED);

			for (Task task : StartedTask) {
				resp.setCode(200);
				resp.setMsg("This is all started Task");
				resp.setRequest(task);
				response.add(resp);
			}
			return response;
			
		} else if (filter.equals(Process.COMPLETED)) {
			List<Task> CompletedTask = repo.findByStatus(Process.COMPLETED);

			for (Task task : CompletedTask) {
				resp.setCode(200);
				resp.setMsg("This is all completed Task");
				resp.setRequest(task);
				response.add(resp);
			}
			return response;
		}
		
		else {
			resp.setCode(400);
			resp.setMsg("Something went wrong");
			return (List<TaskResponse>) resp;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<TaskResponse> filterByCategory(Categories filter){
		List<TaskResponse> response = new ArrayList<>();
		if (filter.equals(Categories.WORK)) {

			List<Task> workTask = repo.findByCategory(Categories.WORK);

			for (Task task : workTask) {
				resp.setCode(200);
				resp.setMsg("This is all Work Task");
				resp.setRequest(task);
				response.add(resp);
			}
			return response;

		} else if (filter.equals(Categories.PERSONAL)) {
			
			List<Task> PersonalTask = repo.findByCategory(Categories.PERSONAL);

			for (Task task : PersonalTask) {
				resp.setCode(200);
				resp.setMsg("This is all Personal Task");
				resp.setRequest(task);
				response.add(resp);
			}
			return response;
			
		} else if (filter.equals(Categories.GYM)) {
			List<Task> GYMTask = repo.findByCategory(Categories.GYM);

			for (Task task : GYMTask) {
				resp.setCode(200);
				resp.setMsg("This is gym completed Task");
				resp.setRequest(task);
				response.add(resp);
			}
			return response;
		}
		
		else {
			resp.setCode(400);
			resp.setMsg("Something went wrong");
			return (List<TaskResponse>) resp;
		}
	}
	
	public List<Task> getAllTask(){
		return repo.findAll();
	}
	
	public TaskResponse deleteTask(Long id) {
		Task task = repo.findById(id).orElse(null);
		if(task == null) {
			resp.setCode(400);
			resp.setMsg("Task is not present");
			return resp;
		} else {
			repo.deleteById(id);
			resp.setCode(200);
			resp.setMsg("Task Deleted Successfully");
			return resp;
		}
		
	}
	
}
