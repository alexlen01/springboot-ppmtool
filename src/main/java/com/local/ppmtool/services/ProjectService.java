package com.local.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.ppmtool.domain.Project;
import com.local.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public Project saveOrUpdateProject(Project project) {

		// Any save or update logic required before saving project to DB.

		return projectRepository.save(project);
	}

}
