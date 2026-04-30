package com.example.demo.DTO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TaskDTO {
    @NotBlank(message = "Title is required")
    private String title;

    @Size(min = 5, message = "Description must be at least 5 characters")
    private String description;
    private boolean completed;

    public TaskDTO(){}

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
