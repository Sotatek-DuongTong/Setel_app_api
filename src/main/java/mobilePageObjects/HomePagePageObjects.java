package mobilePageObjects;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.appium.java_client.AppiumDriver;
import mobileInterfaces.HomePageUIs;

public class HomePagePageObjects extends BasePage {
	AppiumDriver<?> driver;

	public HomePagePageObjects(AppiumDriver<?> driver) {
		this.driver = driver;
	}

	public SearchPageObjects clickSearchIcon(AppiumDriver<?> driver) throws InterruptedException {
		waitForElementClickableById(driver, HomePageUIs.SEARCH_ICON);
		clickToElementById(driver, HomePageUIs.SEARCH_ICON);
		return PageGeneratorManager.getSearchPage(driver);
	}
}
