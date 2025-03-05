package com.ToDo.ToDo_CRUD.repository;

import com.ToDo.ToDo_CRUD.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
