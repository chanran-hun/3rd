package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
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
}
