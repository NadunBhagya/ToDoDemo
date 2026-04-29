package com.example.demo.Model;
import jakarta.persistence.*;

@Entity
public class Task{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private boolean completed;

    public Task() {}

    public Task(Integer id, String title, String description, boolean completed){
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;

    }

    public int getId(){ return id;}
    public void setId(Integer id){this.id = id;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public void setDescription(String description) {this.description = description;}
    public String getDescription() {return description;}

    public void setCompleted(boolean completed) {this.completed = completed;}
    public boolean isCompleted() {return completed;}
}