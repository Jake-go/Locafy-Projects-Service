package com.locafy.local.projects.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.locafy.local.projects.beans.Project;

@Service
public interface ProjectService {
	
	public List<Project> findAll();
	public Project findById(Long id);
	public Project findByTitle(String title);
	public Project save(Project project);

}
