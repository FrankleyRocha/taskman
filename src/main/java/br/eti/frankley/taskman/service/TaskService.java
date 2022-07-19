package br.eti.frankley.taskman.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.frankley.taskman.domain.Task;
import br.eti.frankley.taskman.repo.TaskRepo;

@Service
public class TaskService {

	@Autowired
	private TaskRepo repo;

	public List<Task> all() {
		return repo.findAll();
	}
	
	public Task one(Long id) {
		return repo.findById(id).get();
	}

	public void delete(Long id) {					
		repo.deleteById(id);
	}
	
	public Task save(Task task) {
		return repo.save(task);
	}

}
