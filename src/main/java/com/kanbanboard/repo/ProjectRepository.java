package com.kanbanboard.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kanbanboard.entity.Project;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
	
	//Project findById(long id);
}
