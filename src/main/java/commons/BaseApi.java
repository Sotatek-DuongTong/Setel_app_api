package commons;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class BaseApi {

	public void addHeaderToApiRequest(RequestSpecification apiRequest, String key, Object value, Object... values) {
		apiRequest.header(key, value, values);
	}

	public void addBodyToApiRequest(RequestSpecification apiRequest, String string) {
		apiRequest.body(string);
	}

	public void addParamToApiRequest(RequestSpecification apiRequest, String key, String values) {
		apiRequest.param(key, values);
	}

	public void addPathParamToApiRequest(RequestSpecification apiRequest, String path, String values) {
		apiRequest.pathParams(path, values);
	}

	public Response getPostApiRequestResponse(RequestSpecification apiRequest, String endPoint) {
		return apiRequest.post(endPoint);
	}

	public Response getGetApiRequestResponse(RequestSpecification apiRequest, String endPoint) {
		return apiRequest.get(endPoint);
	}

	public void putValueToJsonObject(String key, String value) {
		requestParams.put(key, value);
	}

	public String convertJsonObjectToString() {
		return requestParams.toJSONString();
	}

	public String getApiRequestBodyValueFormatted(Response response, String key) {
		jsonPathResponse = response.jsonPath();
		return jsonPathResponse.get(key).toString().replace("[", "").replace("]", "");
	}

	public Response getDeleteApiRequestResponse(RequestSpecification apiRequest, String endPoint) {
		return apiRequest.delete(endPoint);
	}

	protected JsonPath jsonPathResponse;
	protected final JSONObject requestParams = new JSONObject();
}
