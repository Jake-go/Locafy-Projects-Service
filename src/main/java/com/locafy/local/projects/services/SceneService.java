package com.locafy.local.projects.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.locafy.local.projects.beans.Scene;

@Service
public interface SceneService {
	
	public List<Scene> findAll();
	
	public Scene findById(Long id);
	
	public Scene save(Scene scene);

}
