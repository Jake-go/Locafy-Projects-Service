package com.locafy.local.projects.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.locafy.local.projects.beans.Scene;
import com.locafy.local.projects.repositories.SceneRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SceneServiceImpl implements SceneService{
	
	private SceneRepository sceneRepository;
	
	public List<Scene> findAll() {
		return sceneRepository.findAll();
	}
	
	public Scene findById(Long id) {
		return sceneRepository.findById(id).orElse(null);
	}
	
	public Scene save(Scene scene) {
		return this.sceneRepository.save(scene);
	}

}
