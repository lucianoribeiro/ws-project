package com.sqa.lp.core;

import java.util.concurrent.*;

import org.openqa.selenium.safari.*;
import org.testng.annotations.*;

import com.sqa.lp.core.*;

public class SafariTest extends Core {

	public SafariTest(String baseURL) {
		super(baseURL);
	}

	@BeforeClass(alwaysRun = true)
	public void setUpChrome() throws Exception {
		// System property to set for Safari specifying the location of
		// testing binary file for Safari.
		setDriver(new SafariDriver());
		// Sets up default implicit wait to wait for 30 seconds
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Set up other window options such as fullscreen
		// this.driver.manage().window().fullscreen();
		getDriver().get(this.getBaseUrl());
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// Closes the WebDriver and quits the browser.
		this.driver.quit();
	}
}
