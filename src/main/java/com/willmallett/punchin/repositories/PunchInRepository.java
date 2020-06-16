package com.willmallett.punchin.repositories;

import com.willmallett.punchin.entities.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PunchInRepository extends JpaRepository<ProjectEntity, UUID> {}
