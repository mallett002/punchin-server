package com.willmallett.punchin.services;

import com.willmallett.punchin.entities.ProjectEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PunchinService {

    private List<ProjectEntity> projects;

    public PunchinService() {
        this.projects = new ArrayList<ProjectEntity>();
    }

    public List<ProjectEntity> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectEntity> projects) {
        this.projects = projects;
    }

    public ProjectEntity addProject(ProjectEntity project) {
        projects.add(project);

        return project;
    }

    public void deleteProject(String id) {
        List<ProjectEntity> updatedProjects = projects.stream()
            .filter(project -> !project.getId().equals(id))
            .collect(Collectors.toList());

        setProjects(updatedProjects);
    }
}
