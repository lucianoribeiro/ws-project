package com.sqa.lp.core;

import java.util.concurrent.*;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.ie.*;
import org.testng.annotations.*;

import com.sqa.lp.core.*;

public class ChromeDrivenTest extends Core {

	public ChromeDrivenTest(String baseURL) {
		super(baseURL);
	}

	@BeforeClass(enabled = false)
	public void setUpChrome() {
		// System property to be set for Chrome specifying the location of the
		// testing binary file for IE.
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		// Run the command, "sudo chmod +x chromedriver" to give rights of
		// executing the chromedriver file
		// Sets up the WebDriver to use Firefox
		setDriver(new ChromeDriver());
		// Sets up default implicit wait to wait for 30 seconds
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Set up other window options such as fullscreen
		// this.driver.manage().window().fullscreen.
		getDriver().get(this.getBaseUrl());
	}

	@BeforeClass()
	public void setUpIE() throws Exception {
		// System property to be set for IE specifying the location of the
		// testing binary file for IE.
		System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
		// Sets up the WebDriver to use Firefox
		setDriver(new InternetExplorerDriver());
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
