package br.eti.frankley.taskman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.eti.frankley.taskman.domain.Task;
import br.eti.frankley.taskman.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping
	public List<Task> all(){
		return taskService.all();
	}
	
	@GetMapping("/{id}")
	public Task one(@PathVariable Long id){
		return taskService.one(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		taskService.delete(id);
	}
	
	@PostMapping
	public Task create(@RequestBody Task task) {
		return taskService.save(task);
	}	

}
