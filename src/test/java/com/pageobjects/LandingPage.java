package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage{
	
	public LandingPage(WebDriver driver) {
		
		super(driver);
		}
			
	@FindBy(xpath="//h1[normalize-space()='Dashboard']") public WebElement msgHeading;
	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]") public WebElement custmenu;
	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]") public WebElement cstmrbtn;
	
	
	public void createcustomer() {
		custmenu.click();
		cstmrbtn.click();
		
		
		/*or
		public void clickOnCustomersMenu() {
			custmenu.click();
		}

		public void clickOnCustomersMenuItem() {
			cstmrbtn.click();
		}*/
		
		
		
		
	}
	
	public boolean isLandingPageExists()   // Landing Page heading display status ("Dashboard")

	{
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}

}
