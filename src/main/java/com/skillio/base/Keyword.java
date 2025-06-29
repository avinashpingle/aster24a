package com.skillio.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.skillio.exceptions.InvalidBrowserNameException;

public class Keyword {
	public static RemoteWebDriver driver;

	public static void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else {
			throw new InvalidBrowserNameException(browserName);
		}
		System.out.println(browserName + " browser is launched successfully...!");
	}

	public static void launchUrl(String url) {
		driver.get(url);
		System.out.println("Url is launched successfully....!");
	}

	public static void clickOnElement(String locatorType, String locator) {
		getWebElement(locatorType, locator).click();
	}

	public static void enterText(String locatorType, String locator, String textToEnter) {
		getWebElement(locatorType, locator).sendKeys(textToEnter);
	}

	private static WebElement getWebElement(String locatorType, String locator) {
		WebElement e = null;
		if (locatorType.equalsIgnoreCase("id")) {
			e = driver.findElement(By.id(locator));
		} else if (locatorType.equalsIgnoreCase("name")) {
			e = driver.findElement(By.name(locator));
		} else if (locatorType.equalsIgnoreCase("class")) {
			e = driver.findElement(By.className(locator));
		} else if (locatorType.equalsIgnoreCase("tagname")) {
			e = driver.findElement(By.tagName(locator));
		} else if (locatorType.equalsIgnoreCase("linktext")) {
			e = driver.findElement(By.linkText(locator));
		} else if (locatorType.equalsIgnoreCase("partiallinktext")) {
			e = driver.findElement(By.partialLinkText(locator));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			e = driver.findElement(By.xpath(locator));
		} else if (locatorType.equalsIgnoreCase("cssselector")) {
			e = driver.findElement(By.cssSelector(locator));
		}
		
		return e;
	}

	public static void closeBrowser() {
		driver.close();
	}

	public void quitAllWindows() {
		driver.quit();
	}

	public static void clickOnElement(By locator) {
		driver.findElement(locator).click();
	}

	public static void enterText(By locator, String textToEnter) {
		driver.findElement(locator).sendKeys(textToEnter);
	}

}
