package com.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageobjects.LandingPage;
import com.pageobjects.LoginPage;
import com.testBase.BaseClass;

public class TC_001_LoginTest extends BaseClass{

	
	@Test
	public void loginTest() throws InterruptedException {
	logger.info(" ******* Starting TC_002_LoginTest *******");
		
		LoginPage lp= new LoginPage(driver);
	
		lp.setUserName(rb.getString("email"));     //valid email , get it from config.properties   // rb=ResourceBundle.getBundle("config");(This is in the BaseClass and it helps to read the config.properties
		lp.setPassword(rb.getString("password")); // valid password, get it from config.properties
		lp.clickLogin();
		
		
		
		//To verify that we landed on the landing page after log in by verifying that we can see the "Dashboard" text on the Landing Page (note: A method is created in the Landing Page and called during Assertion)
		LandingPage ldp= new LandingPage(driver);
		boolean targetpage=ldp.isLandingPageExists();
		
		try {
			Assert.assertEquals(targetpage,true);
		}
		
		catch(Exception e)
		{
			Assert.fail();
	
		
	
		
		
		//OR USE OF PAGE SOURCE TO ASSERT
	/*	boolean res=driver.getPageSource().contains("Dashboard");//just  copy the text(which is any message on the page of interest)and put here
		
		if(res==true)				//We do not rely on ny method for this assertion
		{
		Assert.assertTrue(true);
			
		}else{
		Assert.assertTrue(false);

	logger.info("***********   Finished TC_002_LoginTest **************");*/
			

		}
	
}
}