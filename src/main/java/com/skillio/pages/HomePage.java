package com.skillio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.skillio.utils.WaitFor;
import static com.skillio.base.Keyword.*;

public class HomePage {

	By loginSignupPopupCloseBtn = By.cssSelector("span.icClose");
	By from_txtbx = By.cssSelector("div.sc-12foipm-20:nth-child(1)");
	By from_inputbx = By.cssSelector("input[value]");
	By cityname_1 = By.cssSelector("ul#autoSuggest-list>li:nth-child(1)");
	By toCity = By.cssSelector("div.sc-12foipm-20:nth-child(2)");
	By toCity_txtbx =By.cssSelector("div.sc-12foipm-20:nth-child(2) input");
	
	@FindBy(css = "ul#autoSuggest-list>li:nth-child(1)")
	WebElement toCityName; //null initialize nahi hua
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCloseBtnOnLoginSignupPopup() {
		clickOnElement(loginSignupPopupCloseBtn);
	}

	public void clickOnFromCityTextBox() {
		clickOnElement(from_txtbx);
	}
	public void clickOnToCityTextBox() {
		clickOnElement(toCity);
	}
	
	public void enterFromCity(String cityName) {
		enterText(from_inputbx,cityName);
	}
	
	public void selectCityName() {
		WaitFor.elementToBePresent(cityname_1);
		clickOnElement(cityname_1);
	}

	public void enterToCity(String cityName) {
		enterText(toCity_txtbx , cityName);
	}
	
	public void selectToCityName(String toCityName) {
		WaitFor.elementToBePresent(this.toCityName);
		this.toCityName.click();
	}
}
