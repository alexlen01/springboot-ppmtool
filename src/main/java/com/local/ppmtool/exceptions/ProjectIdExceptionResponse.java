package com.local.ppmtool.exceptions;

public class ProjectIdExceptionResponse {

	private String projectIdentifier;

	public ProjectIdExceptionResponse(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}

	public String getProjectIdentifier() {
		return projectIdentifier;
	}
	
}
