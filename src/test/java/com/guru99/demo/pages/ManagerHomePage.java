package com.guru99.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManagerHomePage {
	WebDriver driver;
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement NewCustomer;

	@FindBy(id="closeBtn")
	WebElement adCloseBtn;
	@FindBy(xpath="//marquee")
	WebElement marquee;

	public ManagerHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void newCustomerLink() {
//		WebDriverWait wait = new WebDriverWait(driver,40);
//		//if(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("closeBtn"))) != null){
//		if(wait.until(ExpectedConditions.visibilityOf(adCloseBtn)) != null){
//			adCloseBtn.click();
//
//		}
		//WebDriverWait wait = new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.elementToBeClickable(adCloseBtn));
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if(driver.findElements(By.id("closeBtn")).size()!=0) {
//			
//			adCloseBtn.click();
//			
//		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", NewCustomer);
		NewCustomer.click();
	}

	public boolean isLoginSuccesfull() {
		if(driver.findElements(By.xpath("marquee")).size()!=0) {
			return true;
		}
		else
			return false;
	}
}
