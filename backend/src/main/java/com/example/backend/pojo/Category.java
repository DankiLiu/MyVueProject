package com.example.backend.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "category")
//在类上声明的@JsonIgnoreProperties是忽略Hibernate的延迟加载的一些属性"hibernateLazyInitializer",
// "handler", "fieldHandler"，这些属性在实体类里没有所以要忽略掉，否则会报错
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})

public class Category {
    //@Id 标注用于声明一个实体类的属性映射为数据库的主键列
    @Id
    //v@GeneratedValue 用于标注主键的生成策略
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    String name;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
