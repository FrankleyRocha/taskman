package br.eti.frankley.taskman.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.eti.frankley.taskman.domain.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long>{

}
