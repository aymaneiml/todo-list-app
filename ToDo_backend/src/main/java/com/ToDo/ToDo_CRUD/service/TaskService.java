package com.ToDo.ToDo_CRUD.service;

import com.ToDo.ToDo_CRUD.model.Task;
import com.ToDo.ToDo_CRUD.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Créer une tâche
    public Task addTask(Task task){
        return taskRepository.save(task);
    }

    // Récupérer toutes les tâches
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Récupérer une tâche par ID
    public Task getById(Long id){
        return taskRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Tâche non trouvée avec l'ID : " + id));
    }

    public Task updateTask(Long id ,Task updateTask){
        return taskRepository.findById(id)
                .map(task->{
                    task.setTitle(updateTask.getTitle());
                    task.setDescription(updateTask.getDescription());
                    task.setStatus(updateTask.getStatus());
                    return taskRepository.save(task);
                })
                .orElseThrow(()-> new IllegalArgumentException("Tâche non trouvée"));
    }


    @Transactional //pour garantir l'intégrité des transactions
    public void deleteTask(Long id){
        if(!taskRepository.existsById(id)){
            throw new IllegalArgumentException("Impossible de supprimer : tâche non trouvée avec l'ID : " + id);
        }
        taskRepository.deleteById(id);
    }



}
