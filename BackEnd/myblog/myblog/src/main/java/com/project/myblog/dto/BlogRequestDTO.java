package com.project.myblog.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogRequestDTO {
    private String title;
    private String content;
    private Long userId;
}
