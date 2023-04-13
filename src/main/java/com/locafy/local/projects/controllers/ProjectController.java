package com.locafy.local.projects.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.locafy.local.projects.beans.Project;
import com.locafy.local.projects.beans.Scene;
import com.locafy.local.projects.services.ProjectServiceImpl;
import com.locafy.local.projects.services.SceneServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/projects")
public class ProjectController {
	
	private final ProjectServiceImpl projectService;
	private final SceneServiceImpl sceneService;
	
	//Get Requests:
	
	@GetMapping(value = {"/", ""})
	public ResponseEntity<?> getAllProjects () {
		
		try {
			List<Project> projects = projectService.findAll();
			if(projects.isEmpty()) {
				return new ResponseEntity<>("No Projects Found", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(projects, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return new ResponseEntity<>("An error occurred while fetching projects", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = {"/{id}"})
	public ResponseEntity<?> getProjectById (@PathVariable Long id) {
		try {
			Project project = projectService.findById(id);
			if(project != null) {
				return ResponseEntity.ok(project);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Project Not Found with ID: " + id);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while retrieving the project: " + e.getMessage());
		}
	}
	
	@GetMapping("/{projectId}/scenes")
	public ResponseEntity<List<Scene>> getScenesForProject(@PathVariable Long projectId){
		try {
			Project project = projectService.findById(projectId);
			if(project == null) {
				return ResponseEntity
						.status(HttpStatus.NOT_FOUND)
						.body(Collections.emptyList());
			} 
			List<Scene> scenes = project.getScenes();
			if(scenes == null) {
				return ResponseEntity
						.status(HttpStatus.NOT_FOUND)
						.body(Collections.emptyList());
			}
			return ResponseEntity.ok(scenes);
		} catch (Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Collections.emptyList());
		}
	}
	
	//End Get Requests
	
	@PostMapping(value = {"/", ""}, headers = {"Content-type=application/json"})
	public ResponseEntity<?> handleProjectCreation(@RequestBody Project project) {
		try {
			
			Project newProject = projectService.save(project);
			
			for (Scene scene : project.getScenes()) {
	            scene.setProject(newProject);
	        }
			
			for (Scene scene : project.getScenes()) {
				sceneService.save(scene);
			}
			
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(new HashMap<String, Object>(){{
						put("message", "Project successfuly saved with ID: "  + newProject.getId());
						put("id", newProject.getId());
						put("title", newProject.getTitle());
					}});
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while saving the project: " + e.getMessage());
		}
	}	

}
