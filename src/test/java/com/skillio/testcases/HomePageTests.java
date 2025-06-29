package com.skillio.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.skillio.base.Keyword;
import com.skillio.base.LocatorType;
import com.skillio.base.Locators;
import com.skillio.base.TestBase;
import com.skillio.pages.HomePage;
import com.skillio.utils.FileUtility;
import static com.skillio.utils.FileUtility.*;
import static com.skillio.base.Keyword.*;
import static com.skillio.base.LocatorType.*;
/**
 * goibibo
 */
public class HomePageTests extends TestBase{

	//span.icClose
	
	public void verifyOneStopFilterForFlights() throws InterruptedException {
		RemoteWebDriver driver = new FirefoxDriver();
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.cssSelector("span.icClose")).click();
		
		driver.findElement(By.cssSelector("div.sc-12foipm-20:nth-child(1)")).click();
		driver.findElement(By.cssSelector("input[value]")).sendKeys("Mumbai");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("ul#autoSuggest-list>li:nth-child(1)")).click();
		
		driver.findElement(By.cssSelector("div.sc-12foipm-20:nth-child(2)")).click();
		
		driver.findElement(By.cssSelector("div.sc-12foipm-20:nth-child(2) input")).sendKeys("Krakow");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("ul#autoSuggest-list>li:nth-child(1)")).click();
		
		driver.findElement(By.cssSelector("div.sc-12foipm-20:nth-child(3)")).click();
		driver.findElement(By.cssSelector("div.DayPicker-Month:nth-child(1)  div.DayPicker-Day--start")).click();
		driver.findElement(By.cssSelector("span.sc-12foipm-72")).click();
		//click on Got It button
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("span[data-testid='coachmark-overlay-button']")).click();
		driver.executeScript("window.scrollBy(0,600)");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div.filterWrapper:nth-child(2)>div.filtersOuter:nth-child(1)>div>div.makeFlex:nth-child(1) label")).click();
		List<WebElement> stoInfoList = driver.findElements(By.cssSelector("div.stop-info p.flightsLayoverInfo font"));
		SoftAssert softly = new SoftAssert();
		for (WebElement stopInfo : stoInfoList) {
			softly.assertTrue(stopInfo.getText().contains("1 stop"),"Stop info = "+stopInfo.getText());
		}
		
		softly.assertAll();
		
		driver.close();
	}
	@Test
	public void verifyOneStopFilterForFlightsUsingKeywords() {
		clickOnElement(CSSSELECTOR, getLocator("login_signup_popup_close_btn"));
		clickOnElement(CSSSELECTOR, Locators.from_txtbx);
		enterText(CSSSELECTOR, Locators.from_txtbx,"Mumbai");
		clickOnElement(CSSSELECTOR, Locators.cityname_1);
	}
	
	@Test
	public void verifyOneStopFilterForFlightsUsingPOM() {
		HomePage homepage = new HomePage();
		homepage.clickOnCloseBtnOnLoginSignupPopup();
		homepage.clickOnFromCityTextBox();
		homepage.enterFromCity("Mumbai");
		homepage.selectCityName();
		homepage.clickOnToCityTextBox();
		homepage.enterToCity("Krakow");
		homepage.selectToCityName("Krakow");
	}
	
}























