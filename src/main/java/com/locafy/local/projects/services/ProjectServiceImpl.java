package com.locafy.local.projects.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.locafy.local.projects.beans.Project;
import com.locafy.local.projects.repositories.ProjectRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService{
	
	private ProjectRepository projectRepository;
	
	@Override
	public List<Project> findAll(){
		return projectRepository.findAll();
	}
	
	@Override
	public Project findById(Long id) {
		return projectRepository.findById(id).orElse(null);
	}
	
	@Override
	public Project findByTitle(String title) {
		Optional<Project> project = projectRepository.findByTitle(title);
		if(project.isPresent()) {
			return project.get();
		} else {
			return null;
		}
	}
	
	@Override
	public Project save(Project project) {
		return projectRepository.save(project);
	}
}
