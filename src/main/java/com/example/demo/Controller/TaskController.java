package com.example.demo.Controller;

import com.example.demo.DTO.TaskDTO;
import com.example.demo.Model.Task;
import com.example.demo.Service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // ✅ GET all tasks
    @GetMapping
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    // ✅ GET task by ID
    @GetMapping("/{id}")
    public Task getTask(@PathVariable int id) {
        return taskService.getTaskById(id);
    }

    // ✅ POST (using DTO)
    @PostMapping
    public Task addTask(@Valid @RequestBody TaskDTO taskDTO) {

        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setCompleted(taskDTO.isCompleted());

        return taskService.addTask(task);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id) {
        return taskService.deleteTask(id)
                ? "Task deleted"
                : "Task not found";
    }

    // ✅ PUT (using DTO)
    @PutMapping("/{id}")
    public String updateTask(@PathVariable int id, @Valid @RequestBody TaskDTO taskDTO) {

        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setCompleted(taskDTO.isCompleted());

        return taskService.updateTask(id, task)
                ? "Task updated"
                : "Task not found";
    }
}
