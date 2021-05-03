package com.example.backend.controller;


import com.example.backend.pojo.User;
import com.example.backend.result.Result;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.util.Objects;

// Controller 负责数据交互，即接收前端发送的数据，通过调用 Service 获得处理后的数据并返回
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value="api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser, HttpSession session){
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, requestUser.getPassword());

        if(null == user){
            System.out.println("user does not exist");
            return new Result(400);
            }
        else{
            session.setAttribute("user", user);
            return new Result(200);
        }
    }
}
