package com.guru99.demo.tests;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru99.demo.pages.AddCustomerPage;
import com.guru99.demo.pages.CustomerRegMsg;
import com.guru99.demo.pages.IndexPage;
import com.guru99.demo.pages.ManagerHomePage;
import com.guru99.demo.utilities.ReadData;


public class AddCustomerPageTest extends BasicTests  {

	WebDriver driver;
	IndexPage indexpage;
	ManagerHomePage managerhomepage;
	AddCustomerPage addcustomerpage;
	CustomerRegMsg customerregmsg;

	@Parameters("browserName")
	@BeforeTest
	void setUpEnvrionment(String browser) {

		//String browserName = ReadData.getValue("BROWSERNAME");
		String url = ReadData.getValue("URL");
		driver = openApplication(browser,url);

	}

	@BeforeClass
	void initiliazeClass() {
		indexpage = new IndexPage(driver); 
		managerhomepage = new ManagerHomePage(driver);
		addcustomerpage = new AddCustomerPage(driver);
		customerregmsg = new CustomerRegMsg(driver);
	}

	@Test
	void messageValidate() {
		String uid = ReadData.getValue("VALIDUID");
		String pwd = ReadData.getValue("VALIDPWD");
		String customerName = ReadData.getValue("CUSTOMERNAME");
		String dateOFBirth = ReadData.getValue("DATEOFBIRTH");
		String address = ReadData.getValue("ADDRESS");
		String city = ReadData.getValue("CITY");
		String state = ReadData.getValue("STATE");
		String pin = ReadData.getValue("PIN");
		String mobileNumber = ReadData.getValue("MOBILENUMBER");
		Random random = new Random();
		String email = "test" + random.nextInt(500) + "test@gmail.com"; //test59test@gmail.com
		//String email = ReadData.getValue("EMAIL");
		String password = ReadData.getValue("PASSWORD");
		String sucessMsg = ReadData.getValue("ACTUALMSG");

		indexpage.setUserID(uid);
		indexpage.setPassword(pwd);
		indexpage.clicklogin();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		managerhomepage.newCustomerLink();

		addcustomerpage.setcustomerName(customerName);
		addcustomerpage.setDateofBirth(dateOFBirth);
		addcustomerpage.setAddress(address);
		addcustomerpage.setcitty(city);
		addcustomerpage.setstate(state);
		addcustomerpage.setPinNumber(pin);
		addcustomerpage.setmobileNumber(mobileNumber);
		addcustomerpage.setEmailId(email);
		addcustomerpage.setPassword(password);
		addcustomerpage.submitButton();

		Assert.assertEquals(customerregmsg.getSuccesmsg(),sucessMsg);
		Assert.assertTrue(customerregmsg.isCustomerCreated(sucessMsg));
	}


	//@Test
	void inValidUIDValidPWDTest() {

		String invaliduid = ReadData.getValue("INVALIDUID");
		String validpwd = ReadData.getValue("VALIDPWD");
		indexpage.setUserID(invaliduid);
		indexpage.setPassword(validpwd);
		indexpage.clicklogin();
		Assert.assertTrue(managerhomepage.isLoginSuccesfull(),"Logged in with Invalid UID and valid Pwd");
	}

	//@Test
	void validUIDInvalidPWDTest() {

		String invaliduid = ReadData.getValue("VALIDUID");
		String validpwd = ReadData.getValue("INVALIDPWD");
		indexpage.setUserID(invaliduid);
		indexpage.setPassword(validpwd);
		indexpage.clicklogin();
		Assert.assertTrue(managerhomepage.isLoginSuccesfull(),"Logged in with Invalid UID and valid Pwd");
	}

	//@Test
	void validUIDValidPWDTest() {

		String invaliduid = ReadData.getValue("VALIDUID");
		String validpwd = ReadData.getValue("VALIDPWD");
		indexpage.setUserID(invaliduid);
		indexpage.setPassword(validpwd);
		indexpage.clicklogin();
		Assert.assertTrue(managerhomepage.isLoginSuccesfull(),"Logged in with Invalid UID and valid Pwd");
	}

}
