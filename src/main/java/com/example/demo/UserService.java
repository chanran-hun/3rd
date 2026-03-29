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

    public UserResponseDto updateUser(Long id, UserRequestDto dto){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 사용자가 없습니다."));

        user.setName(dto.getName());
        user.setAge(dto.getAge());

        User updatedUser = userRepository.save(user);

        return new UserResponseDto(updatedUser.getId(),updatedUser.getName());
    }

    public boolean deleteUser(Long id){
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            userRepository.delete(user.get());
            return true;
        }

        return false;
    }

    public void createUser(UserRequestDto dto){
        User user = new User();
        user.setName(dto.getName());
        user.setAge(dto.getAge());

        userRepository.save(user);
    }
}
