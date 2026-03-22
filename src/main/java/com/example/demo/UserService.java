package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    public String saveUser(User user) {
        users.add(user);
        return "저장 완료: " + user.getName();
    }

    public List<User> getUsers() {
        return users;
    }

    public String introduce(User user) {
        return "이름: " + user.getName() + ", 나이: " + user.getAge();
    }
}
