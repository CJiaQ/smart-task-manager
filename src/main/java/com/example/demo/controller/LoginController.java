package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.until.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LoginController {

    private final UserMapper userMapper;

    public LoginController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
@GetMapping("/")
public String home(){
        return "API running";
}
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User dbUser = userMapper.findByUsername(user.getUsername());

        if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
            String token = JwtUtil.generateToken(dbUser.getUsername());
            return token;
        }
        return "login failed";
    }
}