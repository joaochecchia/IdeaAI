package com.example.IdeaAI.Service;

import com.example.IdeaAI.Dto.ProjectsDto;
import com.example.IdeaAI.Mapper.ProjectsMapper;
import com.example.IdeaAI.Model.Projects;
import com.example.IdeaAI.Repository.ProjectsRepository;
import lombok.AllArgsConstructor;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProjectsService {

    @Autowired
    private final ProjectsRepository projectsRepository;

    @Autowired
    private final ProjectsMapper projectsMapper;

    public ProjectsDto saveProject(ProjectsDto request){
        Projects newProject = projectsRepository.save(projectsMapper.toModel(request));

        return projectsMapper.toDto(newProject);
    }

    public ProjectsDto findProject(Long id){
        Optional<Projects> project = projectsRepository.findById(id);

        return projectsMapper.toDto(project.get());
    }

    public List<ProjectsDto> findAllProjects(){
        List<Projects> allProjects = projectsRepository.findAll();

        return allProjects.stream()
                .map(projectsMapper::toDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ProjectsDto editProject(ProjectsDto request, Long id){
        Projects model = projectsMapper.toModel(request);
        model.setId(id);


        Projects editedRequest = projectsRepository.save(model);


        return projectsMapper.toDto(editedRequest);
    }

    public String deleteProject(Long id){
        projectsRepository.deleteById(id);

        return "Project with + "+ id + " successfully deleted!";
    }
}

