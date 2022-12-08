package mobilePageObjects;

import org.junit.Assert;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.appium.java_client.AppiumDriver;
import mobileInterfaces.SearchPageUIs;

public class SearchPageObjects extends BasePage {
	AppiumDriver<?> driver;

	public SearchPageObjects(AppiumDriver<?> driver) {
		this.driver = driver;
	}

	public void searchProjectName(AppiumDriver<?> driver, String projectname) {
		waitForElementClickableById(driver, SearchPageUIs.SEARCH_TEXTBOX);
		clickToElementById(driver, SearchPageUIs.SEARCH_TEXTBOX);
		sendkeyToElementById(driver, SearchPageUIs.SEARCH_TEXTBOX, projectname);
		sleepInSecond(3);
	}

	public void verifyResultIsCreatedProject(AppiumDriver<?> driver, String projectname) {
		String result = getElementTextbById(driver, SearchPageUIs.SEARCH_RESULT);
		Assert.assertEquals(result, projectname);
	}

	public ProjectDetailsPageObjects clickOnProjectName(AppiumDriver<?> driver) {
		clickToElementById(driver, SearchPageUIs.SEARCH_RESULT);
		return PageGeneratorManager.getProjectDetailsPage(driver);
	}
}
