package commons;

import io.appium.java_client.AppiumDriver;
import mobilePageObjects.HomePagePageObjects;
import mobilePageObjects.LoginPageObjects;
import mobilePageObjects.ProjectDetailsPageObjects;
import mobilePageObjects.SearchPageObjects;

public class PageGeneratorManager {

	public static LoginPageObjects getLoginPage(AppiumDriver<?> driver) {
		return new LoginPageObjects(driver);
	}

	public static HomePagePageObjects getHomePage(AppiumDriver<?> driver) {
		return new HomePagePageObjects(driver);
	}

	public static ProjectDetailsPageObjects getProjectDetailsPage(AppiumDriver<?> driver) {
		return new ProjectDetailsPageObjects(driver);
	}

	public static SearchPageObjects getSearchPage(AppiumDriver<?> driver) {
		return new SearchPageObjects(driver);
	}
}
