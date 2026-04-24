package com.example.demo.Service;

import com.example.demo.Model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private List<Task> tasks =  new ArrayList<>();
    private Integer currenId = 1;

    public List<Task> getAllTasks(){
        return tasks;
    }

    public Task getTaskById(int id){
        return tasks.stream()
                .filter(task -> task.getId()==id)
                .findFirst()
                .orElse(null);
    }

    public Task addTask(Task task){
        task.setId(currenId++);
        tasks.add(task);
        return task;
    }

    public boolean deleteTask(Integer id){
        return tasks.removeIf(task -> task.getId() == id);

    }

    public boolean updateTask(int id, Task updatedTask) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setTitle(updatedTask.getTitle());
                task.setDescription(updatedTask.getDescription());
                task.setCompleted(updatedTask.isCompleted());
                return true;
            }
        }
        return false;
    }




}
