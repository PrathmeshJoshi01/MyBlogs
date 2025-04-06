package com.project.myblog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.myblog.repository.BlogRepository;
import com.project.myblog.repository.UserRepository;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

	
	  @Autowired private BlogRepository blogRepository;
	 
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

	
	  public void blockBlog(Long blogId) {
	  blogRepository.findById(blogId).ifPresent(blog -> { blog.setBlocked(true); //Set the blog as blocked 
	  blogRepository.save(blog); // Save the updated blog
	  }); }
	 
}

