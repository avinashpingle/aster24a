package com.skillio.base;

import org.testng.annotations.BeforeMethod;

import com.skillio.utils.Application;

import static com.skillio.base.Keyword.*;
public class TestBase {

	@BeforeMethod
	public void launchBrowser() {
		openBrowser(Application.getBrowserName());
		launchUrl(Application.getAppUrl("qa"));
	}
	
	
}
