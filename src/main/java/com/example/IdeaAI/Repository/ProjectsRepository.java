package com.example.IdeaAI.Repository;

import com.example.IdeaAI.Model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects, Long> {
}
