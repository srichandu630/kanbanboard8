package com.kanabanboard.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kanbanboard.entity.Project;
import com.kanbanboard.service.ProjectService;

@RestController
@RequestMapping(value="/ProjectAPI")
@CrossOrigin(origins = "http://localhost:4200", methods= {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/AddProject")
	public ResponseEntity<Project> createProject(@Valid @RequestBody Project p) {
		Project p1 = projectService.createProject(p);
		ResponseEntity<Project> rr = new ResponseEntity<Project>(p1, HttpStatus.OK);
		return rr;
	}
	
	@PutMapping("/UpdateProject")
	public ResponseEntity<Project> updateProject(@Valid @RequestBody Project p) throws Throwable {
		Project p1 = projectService.updateProject(p);
		ResponseEntity<Project> rr = new ResponseEntity<Project>(p1, HttpStatus.OK);
		return rr;
	}
	
	@DeleteMapping("/RemoveProject/{id}")
	public String deleteProject(@Valid @PathVariable long id) throws Throwable {
		projectService.removeProject(id);
		return "Project Removed Successfully";
	}
	
	@GetMapping("/getProject")
	public ResponseEntity<List<Project>> getProjects() {
		List<Project> p = projectService.getProject();
		ResponseEntity<List<Project>> p1 = new ResponseEntity<List<Project>>(p, HttpStatus.OK);
		return p1;
	}

}
