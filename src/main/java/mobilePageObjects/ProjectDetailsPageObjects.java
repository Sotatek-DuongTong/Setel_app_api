package mobilePageObjects;

import org.junit.Assert;
import commons.BasePage;
import io.appium.java_client.AppiumDriver;
import mobileInterfaces.ProjectDetailUIs;

public class ProjectDetailsPageObjects extends BasePage {
	AppiumDriver<?> driver;

	public ProjectDetailsPageObjects(AppiumDriver<?> driver) {
		this.driver = driver;
	}

	public void openCreateTaskPopup(AppiumDriver<?> driver) {
		waitForElementClickableById(driver, ProjectDetailUIs.ADD_BUTTON);
		clickToElementById(driver, ProjectDetailUIs.ADD_BUTTON);
	}

	public void createTask(AppiumDriver<?> driver, String taskName) {
		waitForElementClickable(driver, ProjectDetailUIs.TASK_TEXTBOX);
		clickToElement(driver, ProjectDetailUIs.TASK_TEXTBOX);
		sendkeyToElement(driver, ProjectDetailUIs.TASK_TEXTBOX, taskName);
		clickToElement(driver, ProjectDetailUIs.NEXT_BUTTON);
		sleepInSecond(2);
		clickBackButton(driver);
	}

	public void clickOnCheckMark(AppiumDriver<?> driver) {
		waitForElementClickableById(driver, ProjectDetailUIs.CHECKMARK);
		clickToElementById(driver, ProjectDetailUIs.CHECKMARK);
	}

	public void verifyNameTask(AppiumDriver<?> driver, String taskname) {
		waitForElementVisibleById(driver, ProjectDetailUIs.TASK_NAME);
		String currenttask = getElementTextbById(driver, ProjectDetailUIs.TASK_NAME);
		Assert.assertEquals(currenttask, taskname);
	}
}
