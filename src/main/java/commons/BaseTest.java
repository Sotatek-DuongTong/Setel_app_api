package commons;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
	AndroidDriver driver;

	public AndroidDriver<?> openMobile() throws MalformedURLException, InterruptedException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Android Phone");
		caps.setCapability("udid", "emulator-5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "11.0");
		caps.setCapability("skipUnlock", "true");
		caps.setCapability("appPackage", "com.todoist");
		caps.setCapability("appActivity", "com.todoist.activity.HomeActivity");
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		Thread.sleep(5000);
		return (AndroidDriver) driver;
	}

	public RequestSpecification getApiRequest(String baseUrl) {
		RestAssured.baseURI = baseUrl;
		return RestAssured.given();
	}

	public boolean checkApiRequestSttCode(Response response, int expectedStatusCode) {
		Assert.assertTrue(response.getStatusCode() == expectedStatusCode);
		return true;
	}
}
