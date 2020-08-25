package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AdminTab {
	private WebDriver driver; 
	
	public AdminTab(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Administration")
	private WebElement Administration;
	
	@FindBy(partialLinkText="User")
	private WebElement UserList;
	
	@FindBy(xpath="//tr[2]//td[11]//img[@title='Edit']")
	private WebElement EditLink;
	
	@FindBy(partialLinkText="Add a user")
	private WebElement AddUser;
	
	@FindBy(id="firstname")
private WebElement FirstName;

	@FindBy(id="lastname")
private WebElement LastName;
	
	@FindBy(id="email")
private WebElement Email;
	
	@FindBy(id="phone")
	private WebElement PhoneNo;
	
	@FindBy(id="username")
	private WebElement LoginId;
	
	@FindBy(name="password[password_auto]")
	private WebElement PasswordRadioButton;
	
	@FindBy(id="password")
	private WebElement Password;
	
	@FindBy(xpath="//div[@class= 'filter-option-inner-inner' and text()='Learner']")
	private WebElement Profile;
	
	
	@FindBy(xpath="//span[text()='Trainer']")
	private WebElement SelectProfile;
	
	@FindBy(name="submit")
	private WebElement ClickAddButton;
	
	@FindBy(partialLinkText="Course list")
	private WebElement ClickCourseList;
	
	@FindBy(id="course-search-keyword")
	private WebElement SearchCourse;
	
	@FindBy(id="search_simple_submit")
	private WebElement ClickSearchCourse;
	
	@FindBy(xpath="//tr[2]//td[8]//img[@title='Delete']")
	private WebElement DeleteCourse;
	
	@FindBy(xpath="//li[text()='Edit user information']")
	private WebElement CheckEditPage;
	
	@FindBy(xpath="//div[@class='alert alert-info']")
	private WebElement UserAddedMessage;
	
	@FindBy(xpath="//div[@class='alert alert-warning']")
	private WebElement UserInUseAlert;
	
		
	public void ClickAdmin() {
	this.Administration.click();
	}
	
	public void ClickUserList() {
		this.UserList.click();
	}
	public void EditUser() {
		this.EditLink.click();
	}
	
	public void AddUser() {
		this.AddUser.click();
	}

	public String FirstName(String FirstName) {
	 this.FirstName.sendKeys(FirstName);
	return FirstName;
	}
	
	public String LastName(String LastName) {
		this.LastName.sendKeys(LastName);
		return LastName;
			}
	
	public void Email(String Email) {
		this.Email.sendKeys(Email);
			}
	
	public void Phone(String PhoneNo ) {
		this.PhoneNo.sendKeys(PhoneNo);
	}
	
	public void login(String LoginId) {
		this.LoginId.sendKeys(LoginId);
	}
	public void SelectPasswordRadioButton() {
		this.PasswordRadioButton.click();
	}
	public void Password(String Password) {
		this.Password.sendKeys(Password);
				}

	public void ClickAddButton() {
		this.ClickAddButton.click();
	}
	
	public void Profile() {
		this.Profile.click();
	}
	
	public void SelectProfile() {
		this.SelectProfile.click();
	}
	public void ClickCourse() {
		this.ClickCourseList.click();
	}
	public void SearchCourse(String CourseName) {
		this.SearchCourse.sendKeys(CourseName);
		}
	public void ClickSearchCourse() {
		this.ClickSearchCourse.click();
	}
		public void DeleteCourse() {
			this.DeleteCourse.click();
		}
		public String CheckEditPage() {
		return this.CheckEditPage.getText();
		}
		public String GetUserAddedMesage() {
			return this.UserAddedMessage.getText();
		}
		public String GetUserInUseAlert() {
			return this.UserInUseAlert.getText();
		}
		public String AlertDelete() {
			Alert alert=driver.switchTo().alert();
			String DeleteMessage=driver.switchTo().alert().getText();
			alert.accept();
			return DeleteMessage;
							}
}