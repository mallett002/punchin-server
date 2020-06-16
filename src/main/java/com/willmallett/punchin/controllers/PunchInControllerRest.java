package com.willmallett.punchin.controllers;

import com.willmallett.punchin.entities.ProjectEntity;
import com.willmallett.punchin.services.PunchInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
public class PunchInControllerRest {
    @Autowired
    PunchInService punchInService;

    @GetMapping(value = "/projects")
    public ResponseEntity<List<ProjectEntity>> getAllProjects() {
        List<ProjectEntity> projects = punchInService.getProjects();

        if (projects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PostMapping(value = "/add-project", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectEntity> addProject(@RequestBody ProjectEntity project, UriComponentsBuilder builder) {
        try {
            ProjectEntity savedProject = punchInService.addProject(project);

            return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping(value = "/projects/{id}")
    public ResponseEntity<HttpStatus> deleteProjectById(@PathVariable("id") UUID id) {
        try {
            punchInService.deleteProjectById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
