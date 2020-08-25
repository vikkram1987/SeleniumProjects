package com.project.elearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Selenium Jar\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://elearningm1.upskills.in");
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin@123");
		driver.findElement(By.id("form-login_submitAuth")).click();
		driver.findElement(By.linkText("Administration")).click();
		driver.findElement(By.partialLinkText("User")).click();
	//	driver.findElement(By.xpath("//tr[2]//td[text()='karen45']//following-sibling::td[5]//img[@title='Edit']"));
		driver.findElement(By.xpath("//tr[2]//td[11]//img[@title='Edit']")).click();
		
	
		
	}

}
