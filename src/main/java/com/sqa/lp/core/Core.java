package com.sqa.lp.core;

import org.apache.log4j.*;
import org.openqa.selenium.*;

import com.sqa.jf.core.*;
import com.sqa.lp.helpers.*;

public class Core {

	private static int count = 1;

	/**
	 * @return the count
	 */
	public static int getCount() {
		return count;
	}

	private String baseUrl;

	protected WebDriver driver;

	private FirefoxTest curTest;

	private Logger log = Logger.getLogger(this.getClass());

	public Core(FirefoxTest test) {
		this.curTest = test;
		this.baseUrl = test.getBaseUrl();
		this.driver = test.getDriver();
	}

	public Core(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public Core(String baseUrl, WebDriver driver) {
		super();
		this.baseUrl = baseUrl;
		this.driver = driver;
	}

	/**
	 * @return the baseUrl
	 */
	public String getBaseUrl() {
		return this.baseUrl;
	}

	/**
	 * @return the curTest
	 */
	public FirefoxTest getCurTest() {
		return this.curTest;
	}

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return this.driver;
	}

	/**
	 * @return the log
	 */
	public Logger getLog() {
		return this.log;
	}

	// Non static method to get property value given a specific key
	public String getProp(String propName) {
		// return the value of the key based on a file located in
		// src/main/resources/config.properties
		return AutoBasics.getProp(propName, "src/main/resources/", "config.properties", getLog());
	}

	// Method that cheks if an element is present on the page.
	public boolean isElementPresent(String xpathString) {
		return AutoBasics.isElementPresent(getDriver(), By.xpath(xpathString), getLog());
	}

	// Example of a non static implementation of the static helper method
	public void takeScreenshost() {
		AutoBasics.takeScreenshot("screenshots/", "Craigslist Test", count, getDriver(),
				this.getLog());
		count++;
	}

	// Example of a non static implementation of the static helper method
	public void takeScreenshot(String name) {
		AutoBasics.takeScreenshot("screenshots/", name, count, getDriver(), this.getLog());
		count++;
	}

	protected void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	protected void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
