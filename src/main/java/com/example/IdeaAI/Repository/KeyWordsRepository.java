package com.example.IdeaAI.Repository;

import com.example.IdeaAI.Model.KeyWords;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyWordsRepository extends JpaRepository<KeyWords, Long> {
}
