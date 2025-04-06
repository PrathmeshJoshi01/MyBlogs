package com.project.myblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.myblog.dto.BlogDTO;
import com.project.myblog.entity.Blog;
import com.project.myblog.service.BlogService;

@RestController
@RequestMapping("/viewer")
public class ViewerController {

    private final BlogService blogService;

    @Autowired
    public ViewerController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDTO>> viewAllBlogs() {
        return ResponseEntity.ok(blogService.getAllBlogs());
    }
}

