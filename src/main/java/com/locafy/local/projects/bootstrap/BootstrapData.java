package com.locafy.local.projects.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.locafy.local.projects.beans.Project;
import com.locafy.local.projects.beans.Scene;
import com.locafy.local.projects.repositories.ProjectRepository;
import com.locafy.local.projects.repositories.SceneRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

	private ProjectRepository projectRepo;
	private SceneRepository sceneRepo;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Loading Bootstrap Data...");

		// Create two projects
		Project project1 = new Project();
		project1.setTitle("The Last Of Us");
		project1.setTeamMembers(new String[] { "Mohammad Qazzaz", "Travis Coulliard", "Luke Antosz" });
		projectRepo.save(project1);

		Project project2 = new Project();
		project2.setTitle("Top Gun: Maverick");
		project2.setTeamMembers(new String[] { "Lori A. Balton", "Mike Fantasia", "Donny Martino Jr." });
		projectRepo.save(project2);

		// Create four scenes
		Scene scene1 = new Scene();
		scene1.setInOrOut("INT.");
		scene1.setLocation("PLANE HANGAR");
		scene1.setTimeOfDay("DAY");
		scene1.setSceneNumbers("1");
		scene1.setStreetNum("6301");
		scene1.setStreetName("Silver Dart Dr");
		scene1.setPostalCode("L5P 1B2");
		scene1.setCity("Mississauga");
		scene1.setProvince("ON");
		scene1.setCountry("Canada");
		scene1.setProject(project2);
		sceneRepo.save(scene1);

		Scene scene2 = new Scene();
		scene2.setInOrOut("EXT.");
		scene2.setLocation("BOSTON");
		scene2.setTimeOfDay("DAY");
		scene2.setSceneNumbers("33, 34, 35");
		scene2.setStreetNum("1");
		scene2.setStreetName("Hanover St");
		scene2.setPostalCode("02108");
		scene2.setCity("Boston");
		scene2.setProvince("MA");
		scene2.setCountry("USA");
		scene2.setProject(project1);
		sceneRepo.save(scene2);

		Scene scene3 = new Scene();
		scene3.setInOrOut("EXT.");
		scene3.setLocation("BOSTON");
		scene3.setTimeOfDay("DAY");
		scene3.setSceneNumbers("3, 13");
		scene3.setStreetNum("2");
		scene3.setStreetName("Beacon St");
		scene3.setPostalCode("02108");
		scene3.setCity("Boston");
		scene3.setProvince("MA");
		scene3.setCountry("USA");
		scene3.setProject(project1);
		sceneRepo.save(scene3);

		// Create a scene with no set location
		Scene scene4 = new Scene();
		scene4.setInOrOut("EXT.");
		scene4.setLocation("MILITARY BASE");
		scene4.setTimeOfDay("DAY");
		scene4.setSceneNumbers("17");
		scene4.setProject(project2);
		sceneRepo.save(scene4);
	}
}
