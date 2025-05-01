package com.project.myblog.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "blogs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Ensure this is not null
    private User user;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now(); // Default timestamp

    
    @Column(name = "is_blocked", nullable = false)
    private boolean isBlocked = false;  // Default value set in Java

}
