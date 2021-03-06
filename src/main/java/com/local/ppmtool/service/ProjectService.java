package com.local.ppmtool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.ppmtool.domain.Project;
import com.local.ppmtool.exception.ProjectIdException;
import com.local.ppmtool.exception.ProjectNotFoundException;
import com.local.ppmtool.repo.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public Project saveOrUpdateProject(Project project) {
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectRepository.save(project);
		} catch (Exception e) {
			throw new ProjectIdException("Project ID '" + project.getProjectIdentifier() + "' already exists!");
		}
	}

	public Project findProjectByIdentifier(String projectId) {
		Project project = projectRepository.findByProjectIdentifier(projectId);
		if (project != null) {
			return project;
		} else {
			throw new ProjectNotFoundException("Project ID '" + projectId + "' does not exist!");
		}
	}

	public Iterable<Project> findAllProjects() {
		return projectRepository.findAll(); 
	}

	public void deleteProjectByIdentifier(String projectId) {
		Project project = findProjectByIdentifier(projectId);
		projectRepository.delete(project);
	}

}
