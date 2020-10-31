package com.guru99.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class CustomerRegMsg {
	WebDriver driver;

	public CustomerRegMsg(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//p[text()='Customer Registered Successfully!!!']")
	WebElement SuccessMsg;
	
	
	public String getSuccesmsg() {
		return SuccessMsg.getText();
	}
	
	public boolean isCustomerCreated(String successMsg) {
		if(successMsg.equals(SuccessMsg.getText()))
			return true;
		else
			return false;
	}
}
