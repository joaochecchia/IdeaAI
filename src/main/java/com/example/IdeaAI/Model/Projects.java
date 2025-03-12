package com.example.IdeaAI.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "projects")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Projects {

    @Id
    @Column(name = "projects_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] image;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "projects")
    private List<KeyWords> keyWords;
}
