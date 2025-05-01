package com.project.myblog.entity;


import jakarta.persistence.*;
import lombok.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    @Column(unique=true)
    private String email;
    private String role; // USER or ADMIN

    @Column(nullable = false)
    private String password;

    @Column(name = "is_blocked", nullable = false)
    private boolean isBlocked = false;  // Set default value
    
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Blog> blogs;
}
