package com.guru99.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	WebDriver driver;
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='name']")
	WebElement CustomerName;
	
	@FindBy(id="dob")
	WebElement dateofBirth;
	
	@FindBy(name="addr")
	WebElement Address;
	
	
	@FindBy(name="city")
	WebElement City;
	
	@FindBy(name="state")
	WebElement State;
	
	@FindBy(name="pinno")
	WebElement PinNumber;
	
	@FindBy(name="telephoneno")
	WebElement MobileNumber;
	
	@FindBy(name="emailid")
	WebElement EmailId;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement SubmitButton;
	
	public void setcustomerName(String customerName) {
		CustomerName.sendKeys(customerName);
	}
	
	public void setDateofBirth(String DateOfBirth) {
		dateofBirth.sendKeys(DateOfBirth);
		
	}
	
	public void setAddress(String address) {
		Address.sendKeys(address);
	}
	
	public void setcitty(String city) {
		City.sendKeys(city);
	}
	
	public void setstate(String state) {
		State.sendKeys(state);
	}
	
	public void setPinNumber(String pinNumber) {
		PinNumber.sendKeys(pinNumber);
	}
	
	public void setmobileNumber(String mobileNumber) {
		MobileNumber.sendKeys(mobileNumber);
	}
	
	public void setEmailId(String emailId) {
		EmailId.sendKeys(emailId);
	}
	
	public void setPassword(String password) {
		Password.sendKeys(password);
	}
	
	public void submitButton(){
		SubmitButton.click();
		
	}
	
	
	
	

}
