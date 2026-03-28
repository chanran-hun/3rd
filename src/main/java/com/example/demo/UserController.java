package com.example.demo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, 학습자님!";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "지피와 함께 시작!";
    }

    @GetMapping("/name")
    public String name(@RequestParam String name) {
        return "안녕하세요 " + name;
    }

    @GetMapping("/sum")
    public int sum(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

    @PostMapping("/user")
    public void CreateUser(@RequestBody UserRequestDto dto) {
        userService.createUser(dto);
    }

    @PutMapping("/user")
    public User updateUser(@RequestParam Long id, @RequestBody User user) {
        return userService.updateUser(id,user);
    }

    @GetMapping("/user")
    public User getUser(@RequestParam Long id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        boolean deleted = userService.deleteUser(id);

        if(deleted){
            return ResponseEntity.ok("삭제완료");
        } else {
            return ResponseEntity.status(404).body("사용자 없음");
        }
    }

    @GetMapping("/users")
    public List<User> users() {
        return userService.getUsers();
    }
}
