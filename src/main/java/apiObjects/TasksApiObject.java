package apiObjects;

import org.junit.Assert;
import apiEndpoints.TaskApi;
import commons.BaseApi;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TasksApiObject extends BaseApi {
	RequestSpecification apiRequest;

	public TasksApiObject(RequestSpecification apiRequest) {
		this.apiRequest = apiRequest;
	}

	public Response sendGetTasksRequest(String token, String projectId) {
		addHeaderToApiRequest(apiRequest, "Authorization", "Bearer " + token);
		addParamToApiRequest(apiRequest, "project_id", projectId);
		return getGetApiRequestResponse(apiRequest, TaskApi.TASKS);
	}

	public boolean verifyContentTask(String contentTask, String expectContent) {
		Assert.assertEquals(contentTask, expectContent);
		return true;
	}

	public Response sendReopenTasksRequest(String token, String taskId) {
		addHeaderToApiRequest(apiRequest, "Authorization", "Bearer " + token);
		addPathParamToApiRequest(apiRequest, "taskReopenId", taskId);
		return getPostApiRequestResponse(apiRequest, TaskApi.REOPENTASK);
	}
}
