package com.willmallett.punchin.repositories;

import com.willmallett.punchin.entities.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PunchInRepository extends JpaRepository<ProjectEntity, UUID> {

}
