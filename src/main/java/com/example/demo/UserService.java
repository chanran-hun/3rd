package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String introduce(User user) {
        return "이름: " + user.getName() + ", 나이: " + user.getAge();
    }
}
