package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminTab;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class DeleteUser {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AdminTab adminTab;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		adminTab = new AdminTab(driver);
		baseUrl = properties.getProperty("baseURL");
	//	screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		adminTab.ClickCourse();
		adminTab.SearchCourse("vikkram");
		adminTab.ClickSearchCourse();
		adminTab.DeleteCourse();
		adminTab.AlertDelete();
		String DeleteAlertMessage=adminTab.AlertDelete();
		String ExpectedMessage="Please confirm your choice";
		String ActualMessage=DeleteAlertMessage;
		Assert.assertEquals(ActualMessage, ExpectedMessage);
		
		
	//	screenShot.captureScreenShot("First");
	}
}
