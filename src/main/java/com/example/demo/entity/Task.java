package com.example.demo.entity;

public class Task implements java.io.Serializable {

    private Long id;
    private String title;
    private Boolean done;

    public Task(Long id, String title, Boolean done) {
        this.id = id;
        this.title = title;
        this.done = done;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public Boolean getDone() { return done; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDone(Boolean done) { this.done = done; }
}