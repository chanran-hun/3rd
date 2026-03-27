package com.example.demo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    private final UserService userService;

    public HelloController(UserService userService) {
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
    public String user(@RequestBody User user) {
        return userService.saveUser(user);
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
