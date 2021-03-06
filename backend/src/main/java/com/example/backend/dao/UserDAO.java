package com.example.backend.dao;

import com.example.backend.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

// DAO 用于与数据库的直接交互，定义增删改查等操作
public interface UserDAO extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User getByUsernameAndPassword(String username, String password);
}
