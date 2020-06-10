package com.willmallett.punchin.controllers;

import com.willmallett.punchin.entities.ProjectEntity;
import com.willmallett.punchin.services.PunchinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class PunchInControllerRest {
    @Autowired
    PunchinService punchinService;

    @GetMapping(value = "/projects")
    public ResponseEntity<List<ProjectEntity>> getAllProjects() {
        List<ProjectEntity> projects = punchinService.getProjects();

        return ResponseEntity.ok(projects);
    }

    @PostMapping(value = "/add-project", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addProject(@RequestBody ProjectEntity project, UriComponentsBuilder builder) {
        ProjectEntity addedProject;
        try {
            addedProject = punchinService.addProject(project);
        } catch(Exception exception) {
            throw new RuntimeException("Something went wrong adding the project.");
        }

        UriComponents uriComponents = builder.path("/todos").build();

        return ResponseEntity.created(uriComponents.toUri()).body(addedProject);
    }
}
