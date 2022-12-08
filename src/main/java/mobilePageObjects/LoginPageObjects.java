package mobilePageObjects;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.appium.java_client.AppiumDriver;
import mobileInterfaces.LoginUIs;

public class LoginPageObjects extends BasePage {
	AppiumDriver<?> driver;

	public LoginPageObjects(AppiumDriver<?> driver) {
		this.driver = driver;
	}

	public void clickLoginWithEmail(AppiumDriver<?> driver) {
		waitForElementClickableById(driver, LoginUIs.LOGIN_WITH_EMAIL);
		clickToElementById(driver, LoginUIs.LOGIN_WITH_EMAIL);
	}

	public void inputEmail(AppiumDriver<?> driver, String email) {
		waitForElementClickableById(driver, LoginUIs.EMAIL_TEXTBOX);
		clickToElementById(driver, LoginUIs.EMAIL_TEXTBOX);
		sendkeyToElementById(driver, LoginUIs.EMAIL_TEXTBOX, email);
	}

	public void clickContinueButton(AppiumDriver<?> driver) {
		clickToElementById(driver, LoginUIs.CONTINUE_BUTTON);
	}

	public void inputPassword(AppiumDriver<?> driver, String password) {
		waitForElementClickableById(driver, LoginUIs.PASSWORD_TEXTBOX);
		clickToElementById(driver, LoginUIs.PASSWORD_TEXTBOX);
		sendkeyToElementById(driver, LoginUIs.PASSWORD_TEXTBOX, password);
	}

	public HomePagePageObjects clickOnLoginButton(AppiumDriver<?> driver) {
		clickToElementById(driver, LoginUIs.LOGIN_BUTTON);
		sleepInSecond(3);
		clickBackButton(driver);
		return PageGeneratorManager.getHomePage(driver);
	}

}
