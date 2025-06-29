package com.skillio.utils;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.skillio.base.Keyword;

public class WaitFor {

	public static WebDriverWait wait;

	static {
		wait = new WebDriverWait(Keyword.driver, Duration.ofSeconds(60));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withMessage("Element is not available");
	}

	public static void elementToBeClickable(By element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void elementToBePresent(By element) {
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}

	public static void elementToBePresent(WebElement element) {
		Pattern pattern = Pattern.compile("By\\.cssSelector:\\s*(.*?)'");
		Matcher matcher = pattern.matcher(element.toString());
		String locator = "";
		if (matcher.find()) {
			locator = matcher.group(1);
		}
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));

	}
}
