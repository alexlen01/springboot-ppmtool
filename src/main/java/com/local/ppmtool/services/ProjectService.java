package com.local.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.ppmtool.domain.Project;
import com.local.ppmtool.exceptions.ProjectIdException;
import com.local.ppmtool.repositories.ProjectRepository;

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
}
