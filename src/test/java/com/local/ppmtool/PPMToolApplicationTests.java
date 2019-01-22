package com.local.ppmtool;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.junit4.SpringRunner;

import com.local.ppmtool.domain.Project;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { PPMToolApplication.class }, webEnvironment = WebEnvironment.DEFINED_PORT)
public class PPMToolApplicationTests {

	private static final String API_ROOT = "http://localhost:8080/api/project";
	private static final Logger LOGGER = LoggerFactory.getLogger(PPMToolApplicationTests.class);

	private Project createRandomProject() {
		Project project = new Project();
		project.setProjectName(RandomStringUtils.randomAlphabetic(50));
		project.setProjectIdentifier(RandomStringUtils.randomAlphanumeric(5));
		project.setDescription(RandomStringUtils.randomAlphabetic(255));
		project.setStartDate(new Date());
		return project;
	}

	private static String createProjectAsUri(Project Project) {
		Response response = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE).body(Project).post(API_ROOT);
		return API_ROOT + "/" + response.jsonPath().get("projectIdentifier");
	}

	@Test
	@Repeat(value = 10)
	public void whenGetCreatedProjectById_thenOK() {
		Project project = createRandomProject();
		String location = createProjectAsUri(project);
		Response response = RestAssured.get(location);		
		assertEquals(HttpStatus.OK.value(), response.getStatusCode());
		assertEquals(project.getProjectName(), response.jsonPath().get("projectName"));
		LOGGER.info(location + " (GetCreatedProjectById) -->> " + response.jsonPath().get("projectName"));
	}

	@Test
	public void whenGetNotExistProjectById_thenNotFound() {
		String location = API_ROOT + "/" + RandomStringUtils.randomAlphanumeric(5);
		Response response = RestAssured.get(location);
		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
	}

	@Test
	public void whenCreateNewProject_thenCreated() {
	    Project project = createRandomProject();
	    Response response = RestAssured.given()
	      .contentType(MediaType.APPLICATION_JSON_VALUE)
	      .body(project)
	      .post(API_ROOT);
		assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
	}
	 
	@Test
	public void whenGetAllProjects_thenOK() {
		String location = API_ROOT + "/all";
		Response response = RestAssured.get(location);
		assertEquals(HttpStatus.OK.value(), response.getStatusCode());
		LOGGER.info(location + " (GetAllProjects): " + response.jsonPath().prettify());
	}

	@Test
	public void whenUpdateCreatedProject_thenUpdated() {
		String location = API_ROOT + "/all";
		Response response = RestAssured.get(location);

		assertEquals(HttpStatus.OK.value(), response.getStatusCode());

		List<Project> projects = response.jsonPath().getList("$", Project.class);

		assertNotNull(projects);

		Project project = projects.get(0);

		location = createProjectAsUri(project);

		project.setProjectName("New Project Name");
	    project.setDescription("Project description goes here");

	    response = RestAssured.given()
	      .contentType(MediaType.APPLICATION_JSON_VALUE)
	      .body(project)
	      .post(API_ROOT);

	    assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());

	    response = RestAssured.get(location);

	    assertEquals(HttpStatus.OK.value(), response.getStatusCode());
	    assertEquals("New Project Name", response.jsonPath().get("projectName"));
		LOGGER.info(location + " (UpdateCreatedProject): " + response.jsonPath().prettify());
	}

	@Test
	public void whenDeleteCreatedProject_thenOk() {
	    Project Project = createRandomProject();
	    String location = createProjectAsUri(Project);
	    Response response = RestAssured.delete(location);

	    assertEquals(HttpStatus.OK.value(), response.getStatusCode());

	    response = RestAssured.get(location);
	    assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
	}
	
	@Test
	public void whenInvalidProject_thenError() {
	    Project project = createRandomProject();
	    project.setProjectName(null);
	    Response response = RestAssured.given()
	      .contentType(MediaType.APPLICATION_JSON_VALUE)
	      .body(project)
	      .post(API_ROOT);

	    assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode());
	}

}

