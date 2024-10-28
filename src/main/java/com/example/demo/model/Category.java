package com.example.demo.model; // Đảm bảo rằng package này tồn tại

import java.io.Serializable;

public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String image;
    private int status;

    public Category() {
        super();
    }

    // Getters và Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", image=" + image + ", status=" + status + "]";
    }
}
