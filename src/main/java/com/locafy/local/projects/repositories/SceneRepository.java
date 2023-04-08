package com.locafy.local.projects.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locafy.local.projects.beans.Scene;

public interface SceneRepository extends JpaRepository<Scene, Long>{
}
