package com.project.myblog.controller;

import com.project.myblog.dto.BlogDTO;
import com.project.myblog.dto.BlogRequestDTO;
import com.project.myblog.dto.LoginRequest;
import com.project.myblog.entity.User;
import com.project.myblog.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // ✅ Register user
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    // ✅ Get all users
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // ✅ Login user
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        User user = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
        if (user != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("id", user.getId()); // Make sure frontend expects "id"
            response.put("name", user.getName());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    // ✅ Create blog with userId
    @PostMapping("/blogs")
    public ResponseEntity<BlogDTO> createBlog(@RequestParam Long userId, @RequestBody BlogRequestDTO blogRequestDTO) {
        BlogDTO createdBlog = userService.createBlog(userId, blogRequestDTO);
        return ResponseEntity.ok(createdBlog);
    }

    // ✅ Get all blogs of a user
    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDTO>> getUserBlogs(@RequestParam Long userId) {
        List<BlogDTO> blogs = userService.getUserBlogs(userId);
        return ResponseEntity.ok(blogs);
    }
}
