package com.willmallett.punchin.services;

import com.willmallett.punchin.entities.ProjectEntity;
import com.willmallett.punchin.entities.TimeEntry;
import com.willmallett.punchin.repositories.PunchInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public ProjectEntity addTimeEntryForProject(UUID projectId, TimeEntry timeEntry) {
        Optional<ProjectEntity> optionalProjectEntity = punchInRepository.findById(projectId);

        if (optionalProjectEntity.isPresent()) {
            ProjectEntity project = optionalProjectEntity.get();
            project.addTimeEntry(timeEntry);
            project.setPunchIns(project.getPunchIns() + 1);
            project.setTotalPay(project.getTotalPay() + timeEntry.getTimeEntryPay());
            project.setTotalTime(project.getTotalTime() + timeEntry.getTimeEntryTotal());

            return punchInRepository.save(project);
        }

        return null;
    }

    public void deleteProjectById(UUID id) {
        punchInRepository.deleteById(id);
    }
}
