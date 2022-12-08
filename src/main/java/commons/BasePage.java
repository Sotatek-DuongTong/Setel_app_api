package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

public class BasePage {
	public static MobileElement mobileElement;

	public static BasePage getBasePage() {
		return new BasePage();
	}

	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public MobileElement getElement(AppiumDriver<?> driver, String locator) {
		return (MobileElement) driver.findElement(getByXpath(locator));
	}

	public MobileElement getElementById(AppiumDriver<?> driver, String locator) {
		return (AndroidElement) driver.findElement(getById(locator));
	}

	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public By getById(String locator) {
		return By.id(locator);
	}

	public void clickToElement(AppiumDriver<?> driver, String locator) {
		getElement(driver, locator).click();
	}

	public void clickToElementById(AppiumDriver<?> driver, String locator) {
		getElementById(driver, locator).click();
	}

	public void sendkeyToElement(AppiumDriver<?> driver, String locator, String value) {
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}

	public void sendkeyToElementById(AppiumDriver<?> driver, String locator, String value) {
		getElementById(driver, locator).clear();
		getElementById(driver, locator).sendKeys(value);
	}

	public String getElementTextbById(AppiumDriver<?> driver, String locator) {
		return getElementById(driver, locator).getText();
	}

	public boolean isElementDisplayed(AppiumDriver<?> driver, String locator) {
		try {
			return getElement(driver, locator).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void waitForElementVisibleById(AppiumDriver<?> driver, String locator) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getById(locator)));
	}

	public void waitForElementClickable(AppiumDriver<?> driver, String locator) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}

	public void waitForElementClickableById(AppiumDriver<?> driver, String locator) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getById(locator)));
	}

	public void clickBackButton(AppiumDriver<?> driver) {
		driver.navigate().back();
	}

	private WebDriverWait explicitWait;
	protected long timeout = 30;
}
