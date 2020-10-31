package com.guru99.demo.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicTests {
	
	WebDriver openApplication(String browserName, String url) {
		
		ThreadLocal<RemoteWebDriver> threadDriver = new ThreadLocal<RemoteWebDriver>();
		
		URL hubURL = null;
		try {
			hubURL = new URL("http://localhost:4444/wd/hub");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setBrowserName(browserName);
		RemoteWebDriver remoteWebDriver = new RemoteWebDriver(hubURL, cap);
		threadDriver.set(remoteWebDriver);
		threadDriver.get().get(url);

		return threadDriver.get();
	}

}
