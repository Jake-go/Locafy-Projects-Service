package com.locafy.local.projects.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locafy.local.projects.beans.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	public Optional<Project> findByTitle(String title);
}
