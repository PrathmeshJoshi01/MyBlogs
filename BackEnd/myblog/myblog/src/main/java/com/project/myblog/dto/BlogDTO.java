package com.project.myblog.dto;


import lombok.*;
import java.time.LocalDateTime;

import com.project.myblog.entity.Blog;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogDTO {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String authorName;
    
    
    

}

