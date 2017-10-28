package com.sqa.lp.core;

import java.util.concurrent.*;

import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;

import com.sqa.lp.core.*;

public class FirefoxDrivenTest extends Core {

	public FirefoxDrivenTest(String baseURL) {
		super(baseURL);
	}

	@BeforeClass(enabled = true)
	public void setUpFirefox() {
		// System property to be set for Chrome specifying the location of the
		// testing binary file for IE.
		// Run the command, "sudo chmod +x chromedriver" to give rights of
		// executing the chromedriver file
		// Sets up the WebDriver to use Firefox
		setDriver(new FirefoxDriver());
		// Sets up default implicit wait to wait for 30 seconds
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Set up other window options such as fullscreen
		// this.driver.manage().window().fullscreen();
		getDriver().get(this.getBaseUrl());
	}

	// After class is run one time after
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// Closes the WebDriver and quits the browser.
		getDriver().quit();
	}
}
