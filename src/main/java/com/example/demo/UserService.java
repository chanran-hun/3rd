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

    public User getUser(int index) {
        if(index < 0 || index >= users.size()){
            throw new IllegalArgumentException("존재하지 않는 사용자입니다.");
        }
        return users.get(index);
    }
}
