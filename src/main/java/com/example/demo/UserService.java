package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public String saveUser(User user){
        userRepository.save(user);
        return "저장 완료: " + user.getName();
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
    }

    public User updateUser(Long id, User updateduser){
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));

        user.setName(updateduser.getName());
        user.setAge(updateduser.getAge());

        return userRepository.save(user);
    }

    public boolean deleteUser(Long id){
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            userRepository.delete(user.get());
            return true;
        }

        return false;
    }
}
