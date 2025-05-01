package com.project.myblog.controller;


import com.project.myblog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        adminService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    @PutMapping("/blogs/block/{id}")
    public ResponseEntity<String> blockBlog(@PathVariable Long id) {
        adminService.blockBlog(id);
        return ResponseEntity.ok("Blog blocked successfully");
    }
}
