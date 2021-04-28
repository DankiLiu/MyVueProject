package com.example.backend.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

// 建立对数据库的映射
@Entity
@Table(name="user")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    String username;
    String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        System.out.println("User -> Get username from database" + username);
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        System.out.println("User -> Get password from database" + password);
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
