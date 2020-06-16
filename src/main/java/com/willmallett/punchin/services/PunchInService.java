package com.willmallett.punchin.services;

import com.willmallett.punchin.entities.ProjectEntity;
import com.willmallett.punchin.repositories.PunchInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PunchInService {

    @Autowired
    PunchInRepository punchInRepository;

    public ProjectEntity addProject(ProjectEntity project) {
        return punchInRepository.save(project);
    }

    public List<ProjectEntity> getProjects() {
        return punchInRepository.findAll();
    }

    public void deleteProjectById(UUID id) {
        punchInRepository.deleteById(id);
    }
}
