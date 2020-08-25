package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.NoSuchElementException;
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

public class AddUser {

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
		//driver.quit();
	}
	@Test
	public void ViewUserDetails() {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		adminTab.ClickAdmin();
		adminTab.AddUser();
	String FirstName=adminTab.FirstName("vikkram2");
	String LastName=adminTab.LastName("sasidharan2");
		adminTab.Email("vikkram@gmail.com");
		adminTab.Phone("9876543210");
		adminTab.login("vikkram5");
		adminTab.SelectPasswordRadioButton();
		adminTab.Password("vikkram2");
		adminTab.Profile();
		adminTab.SelectProfile();
		adminTab.ClickAddButton();
	
		
	 //  	String ActualResult=("The user has been added:"+ FirstName +LastName);
	//	String ExpectedResult=("The user had been added:vikkram2sasidharan2");
	//	System.out.println(ActualResult);
	 //   Assert.assertEquals(ActualResult, ExpectedResult);
		    try {
		    adminTab.GetUserAddedMesage();
			 String ActualResult=("The user has been added:"+ FirstName +LastName);
			 String ExpectedResult=("The user had been added:vikkram2sasidharan2");
					System.out.println(ActualResult);
				    Assert.assertEquals(ActualResult, ExpectedResult);
	    }
	    catch(NoSuchElementException a) {
	  	adminTab.GetUserInUseAlert();
	    			System.out.println("This login is already in use");
	    }
	//screenShot.captureScreenShot("First");
	
	
	}
}
