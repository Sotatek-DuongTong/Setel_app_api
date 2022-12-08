package apiObjects;

import apiEndpoints.ProjectApi;
import commons.BaseApi;
import commons.GlobalConstants;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ProjectsApiObject extends BaseApi {
    RequestSpecification apiRequest;
    String projectId;

    public ProjectsApiObject(RequestSpecification apiRequest) {
        this.apiRequest = apiRequest;
    }
   
    public Response sendCreatePrjRequest(String token, String projectName) {
		addHeaderToApiRequest(apiRequest, "Authorization", "Bearer " + GlobalConstants.TOKEN);
		addHeaderToApiRequest(apiRequest, "Content-Type", "application/json");
		addHeaderToApiRequest(apiRequest, "X-Request-Id", "$(uuidgen)");
        putValueToJsonObject("name",projectName);
        addBodyToApiRequest(apiRequest, convertJsonObjectToString());     
        return getPostApiRequestResponse(apiRequest, ProjectApi.PROJECTURL);
    }
    
    public String getProjectId(Response response) {
    	projectId = getApiRequestBodyValueFormatted(response, "id");
		return projectId;
    }

    public Response sendDeletePrjRequest(String token, String prjId) {
        addHeaderToApiRequest(apiRequest,"Authorization", "Bearer " + token);
        addPathParamToApiRequest(apiRequest, "projectId", prjId);
        return getDeleteApiRequestResponse(apiRequest, ProjectApi.DELETPRJURL);
    }
}
