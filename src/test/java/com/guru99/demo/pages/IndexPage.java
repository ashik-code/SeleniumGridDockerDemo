package com.guru99.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	WebDriver driver;

	@FindBy(xpath="//input[@type='text']")
	WebElement userId;

	@FindBy(xpath="//input[@type='password']")
	WebElement password;

	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	
	

	public IndexPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void setUserID(String UserId) {
		userId.sendKeys(UserId);
	}

	public void setPassword(String Password) {
		password.sendKeys(Password);
	}

	public void clicklogin() {
		loginButton.click();
	}
	
	






}
