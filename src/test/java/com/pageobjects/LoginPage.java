package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		
		super(driver);
		}
			
	@FindBy(id="Email") public WebElement txtEmail;
	@FindBy(id = "Password") public WebElement txtPassword;
	@FindBy(xpath = "//button[normalize-space()='Log in']") public WebElement loginbtn;  
	@FindBy(xpath="//a[contains(normalize-space(),'Logout')]") public WebElement lnkLogout;
	
	
	

public void setUserName(String uname) throws InterruptedException {
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}

	public void setPassword(String pwd) throws InterruptedException {
        txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {

		loginbtn.click();
	
	}
	public void clickLogout() {

		lnkLogout.click();
	

		
	}
	public void  SetLogin(String email, String pwd) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
		 txtPassword.clear();
		txtPassword.sendKeys(pwd);
		loginbtn.click();
		
		
	
	}
}
