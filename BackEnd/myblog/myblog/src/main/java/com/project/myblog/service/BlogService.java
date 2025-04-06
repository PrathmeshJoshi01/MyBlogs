package com.project.myblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.myblog.dto.BlogDTO;
import com.project.myblog.dto.BlogRequestDTO;
import com.project.myblog.entity.Blog;
import com.project.myblog.entity.User;
import com.project.myblog.repository.BlogRepository;
import com.project.myblog.repository.UserRepository;

import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;
	private UserRepository userRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository, UserRepository userRepository) {
        this.blogRepository = blogRepository;
        this.userRepository = userRepository;
    }
    
    public BlogDTO createBlog(BlogRequestDTO blogRequestDTO) {
        User user = userRepository.findById(blogRequestDTO.getUserId())
                                  .orElseThrow(() -> new RuntimeException("User not found"));

        Blog blog = new Blog();
        blog.setTitle(blogRequestDTO.getTitle());
        blog.setContent(blogRequestDTO.getContent());
        blog.setCreatedAt(LocalDateTime.now());
        blog.setUser(user); // Ensure the blog is linked to a user
        blog.setBlocked(false); // ✅ Explicitly setting isBlocked to false
        blogRepository.save(blog);

        Blog savedBlog = blogRepository.save(blog); // Saving to the database

        return new BlogDTO(
        		savedBlog.getId(), 
        		savedBlog.getTitle(), 
        		savedBlog.getContent(), 
        		savedBlog.getCreatedAt(), 
        		savedBlog.getUser().getName()
        		);
    }

    
    public List<BlogDTO> getAllBlogs() {
        List<Blog> blogs = blogRepository.findAll(); // Fetch from DB
        return blogs.stream()
                    .map(blog -> new BlogDTO(blog.getId(), blog.getTitle(), blog.getContent(), blog.getCreatedAt(), blog.getUser().getName()))
                    .collect(Collectors.toList());
    }

    public Blog getBlogById(Long id) {
        return blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog not found"));
    }
    
    public boolean deleteBlog(Long id) {
        if (blogRepository.existsById(id)) {
            blogRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
