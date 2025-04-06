package com.project.myblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.myblog.dto.BlogDTO;
import com.project.myblog.dto.BlogRequestDTO;
import com.project.myblog.entity.Blog;
import com.project.myblog.entity.User;
import com.project.myblog.repository.BlogRepository;
import com.project.myblog.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogRepository blogRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        throw new RuntimeException("Invalid credentials");
    }

    public BlogDTO createBlog(Long userId, BlogRequestDTO blogRequestDTO) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

        Blog blog = new Blog();
        blog.setTitle(blogRequestDTO.getTitle());
        blog.setContent(blogRequestDTO.getContent());
        blog.setUser(user);
        blog.setCreatedAt(LocalDateTime.now());

        Blog savedBlog = blogRepository.save(blog);

        return convertToDTO(savedBlog);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ✅ FIXED: Return List<BlogDTO> instead of List<Blog>
    public List<BlogDTO> getUserBlogs(Long userId) {
        List<Blog> blogs = blogRepository.findByUserId(userId);
        return blogs.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // 🔁 Helper method to convert Blog → BlogDTO
    private BlogDTO convertToDTO(Blog blog) {
        BlogDTO dto = new BlogDTO();
        dto.setId(blog.getId());
        dto.setTitle(blog.getTitle());
        dto.setContent(blog.getContent());
        dto.setCreatedAt(blog.getCreatedAt());
        dto.setAuthorName(blog.getUser().getName());
        return dto;
    }
}
