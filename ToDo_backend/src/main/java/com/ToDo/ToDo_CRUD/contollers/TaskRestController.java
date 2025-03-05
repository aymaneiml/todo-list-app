package com.ToDo.ToDo_CRUD.contollers;

import com.ToDo.ToDo_CRUD.model.Task;
import com.ToDo.ToDo_CRUD.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@CrossOrigin(origins = "http://localhost:63342")  // Permet l'accès depuis ton frontend
public class TaskRestController {

    @Autowired
    private TaskService taskService;

    //Ajout de @RequestBody dans createTask() pour permettre l'envoi des données en JSON.
    @PostMapping("/createTask")
    public Task createTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    @GetMapping("/getAll")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/getTask/{id}")
    public Task getTaskById(@PathVariable("id") Long id){
        return taskService.getById(id);
    }

    @PutMapping("/updateTask/{id}")
    public Task updateTask(@PathVariable("id") Long id,@RequestBody Task updatedTask){
        return taskService.updateTask(id,updatedTask);
    }

    @DeleteMapping("/deleteTask/{id}")
    public void deleteTaskById(@PathVariable("id") Long id){
        taskService.deleteTask(id);
    }


}
