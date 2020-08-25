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
import org.testng.asserts.Assertion;

import com.training.generics.ScreenShot;
import com.training.pom.AdminTab;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ViewUserDetails {

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
	public void ViewUserDetails() {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		adminTab.ClickAdmin();
		adminTab.ClickUserList();
		adminTab.EditUser();
	String message=	adminTab.CheckEditPage();
		System.out.println(message);
		String ExpectedResults="Edit user information";
		String ActualResults=adminTab.CheckEditPage();
		Assert.assertEquals(ActualResults, ExpectedResults);
		System.out.println(ActualResults);
	//	screenShot.captureScreenShot("First");
	}
}
