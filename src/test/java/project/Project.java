package project;

import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import apiObjects.ApiObjectCreator;
import apiObjects.ProjectsApiObject;
import apiObjects.TasksApiObject;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import io.appium.java_client.AppiumDriver;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import mobilePageObjects.HomePagePageObjects;
import mobilePageObjects.LoginPageObjects;
import mobilePageObjects.ProjectDetailsPageObjects;
import mobilePageObjects.SearchPageObjects;

public class Project extends BaseTest {
	AppiumDriver<?> driver;
	String projectId;
	String taskId;
	String contentTask;
	String responseBodyAsString;
	RequestSpecification apiRequest;
	Response response;
	Response verifyTask;
	Response reopenTask;
	Response deleteProject;
	int statusCode;

	@BeforeTest
	public void InitTest() throws MalformedURLException, InterruptedException {
		driver = openMobile();
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}

	@Test
	public void createProject() throws InterruptedException {
		apiRequest = getApiRequest(GlobalConstants.BASEURL);
		projectsApi = ApiObjectCreator.getProjectsApi(apiRequest);
		response = projectsApi.sendCreatePrjRequest(GlobalConstants.TOKEN, GlobalConstants.PROJECTNAME);
		checkApiRequestSttCode(response, 200);
		projectId = projectsApi.getProjectId(response);

		loginPage.clickLoginWithEmail(driver);
		loginPage.inputEmail(driver, GlobalConstants.EMAIL);
		loginPage.clickContinueButton(driver);
		loginPage.inputPassword(driver, GlobalConstants.PASSWORD);
		homePage = loginPage.clickOnLoginButton(driver);
		searchPage = homePage.clickSearchIcon(driver);
		searchPage.searchProjectName(driver, GlobalConstants.PROJECTNAME);
		searchPage.verifyResultIsCreatedProject(driver, GlobalConstants.PROJECTNAME);
	}

	@Test
	public void createTask() throws InterruptedException {
		projectDetailsPage = searchPage.clickOnProjectName(driver);
		projectDetailsPage.openCreateTaskPopup(driver);
		projectDetailsPage.createTask(driver, GlobalConstants.TASKNAME);
		projectDetailsPage.sleepInSecond(5);
		
		apiRequest = getApiRequest(GlobalConstants.BASEURL);
		tasksApi = ApiObjectCreator.getTasksApi(apiRequest);
		verifyTask = tasksApi.sendGetTasksRequest(GlobalConstants.TOKEN, projectId);
		taskId = tasksApi.getApiRequestBodyValueFormatted(verifyTask, "id");
		contentTask = tasksApi.getApiRequestBodyValueFormatted(verifyTask, "content");
		checkApiRequestSttCode(verifyTask,200);
		tasksApi.verifyContentTask( GlobalConstants.TASKNAME, contentTask);
	}

	@Test
	public void reopenTask() throws InterruptedException {
		projectDetailsPage.clickOnCheckMark(driver);
		projectDetailsPage.sleepInSecond(5);

		apiRequest = getApiRequest(GlobalConstants.BASEURL);
		tasksApi = ApiObjectCreator.getTasksApi(apiRequest);
		reopenTask = tasksApi.sendReopenTasksRequest(GlobalConstants.TOKEN, taskId);
		checkApiRequestSttCode(reopenTask, 204);
		projectDetailsPage.sleepInSecond(30);
		projectDetailsPage.verifyNameTask(driver, GlobalConstants.TASKNAME);

		apiRequest = getApiRequest(GlobalConstants.BASEURL);
		projectsApi = ApiObjectCreator.getProjectsApi(apiRequest);
		deleteProject = projectsApi.sendDeletePrjRequest(GlobalConstants.TOKEN, projectId);
		checkApiRequestSttCode(deleteProject, 204);
	}

	@AfterTest
	public void EndTest() {
		driver.quit();
	}
	LoginPageObjects loginPage;
	HomePagePageObjects homePage;
	ProjectDetailsPageObjects projectDetailsPage;
	SearchPageObjects searchPage;
	ProjectsApiObject projectsApi;
	TasksApiObject tasksApi;
}
