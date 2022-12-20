package com.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
public WebDriver driver;
public WebDriverWait wait;

	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
		// wait for page to load
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		// wait= new WebDriverWait (driver, 5);  //deprecated in Selenium 4

	}

}
