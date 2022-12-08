package apiObjects;

import io.restassured.specification.RequestSpecification;

public class ApiObjectCreator {
    public static ProjectsApiObject getProjectsApi(RequestSpecification apiRequest) {
        return new ProjectsApiObject(apiRequest);
    }

    public static TasksApiObject getTasksApi(RequestSpecification apiRequest) {
        return new TasksApiObject(apiRequest);
    }
}
