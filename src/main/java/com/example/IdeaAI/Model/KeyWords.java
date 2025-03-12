package com.example.IdeaAI.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "key_words")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KeyWords {

    @Id
    @Column(name = "keywords_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keyWord;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Projects projects;
}
