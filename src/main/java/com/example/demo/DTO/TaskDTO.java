package com.example.demo.DTO;


import jakarta.validation.constraints.NotBlank;

public class TaskDTO {
    @NotBlank(message = "Title is required")
    private String title;
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
