package com.willmallett.punchin.controllers;

import com.willmallett.punchin.dtos.Note;
import com.willmallett.punchin.entities.ProjectEntity;
import com.willmallett.punchin.entities.TimeEntry;
import com.willmallett.punchin.services.PunchInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@CrossOrigin
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

    @PutMapping("/projects/{id}/add-time-entry")
    public ResponseEntity<ProjectEntity> addTimeEntry(@PathVariable("id") UUID projectId, @RequestBody TimeEntry timeEntry) {
        try {
            ProjectEntity project = punchInService.addTimeEntryForProject(projectId, timeEntry);

            if (project != null) {
                return new ResponseEntity<>(project, HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/projects/{id}/add-note")
    public ResponseEntity<ProjectEntity> addTimeEntry(@PathVariable("id") UUID projectId, @RequestBody Note note) {
        try {
            ProjectEntity project = punchInService.updateNoteForProject(projectId, note);

            if (project != null) {
                return new ResponseEntity<>(project, HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<HttpStatus> deleteProjectById(@PathVariable("id") UUID id) {
        try {
            punchInService.deleteProjectById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/projects/{projectId}/timeEntries/{timeEntryId}")
    public ResponseEntity<ProjectEntity> deleteTimeEntry(
        @PathVariable("projectId") UUID projectId,
        @PathVariable("timeEntryId") UUID timeEntryId
    ) {
        try {
            ProjectEntity project = punchInService.deleteTimeEntry(projectId, timeEntryId);

            if (project != null) {
                return new ResponseEntity<>(project, HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
