package com.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageobjects.CustomerPage;
import com.pageobjects.LandingPage;
import com.pageobjects.LoginPage;
import com.testBase.BaseClass;

public class TC_003_SearchCustomerByEmail extends BaseClass {
	
	@Test
	
	
	public void searchCustomerbyEmail() throws InterruptedException {
		
		LoginPage lp= new LoginPage(driver);
		//lp.SetLogin("admin@yourstore.com","admin");  // This action method was not hard coded
		lp.setUserName(rb.getString("email"));     //valid email , get it from config.properties   // rb=ResourceBundle.getBundle("config");(This is in the BaseClass and it helps to read the config.properties
		lp.setPassword(rb.getString("password")); // valid password, get it from config.properties
		lp.clickLogin();
		LandingPage ld= new LandingPage(driver);
		
			
		ld.createcustomer();
		CustomerPage cp=new CustomerPage(driver);
		cp.setEmail("victoria_victoria@nopCommerce.com");
		cp.clickSearch();
		Thread.sleep(3000);
	//	cp.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		
		boolean status=cp.searchCustomerByEmail("victoria_victoria@nopCommerce.com");  // A method (searchCustomerByEmail) was created using For Loop to search if the email actually exists in the table in the CustomerPage
		if(status==true)				
		{
		Assert.assertTrue(true);
			
		}else{
		Assert.assertTrue(false);
		
	}
		//Assert.assertEquals(true, status);

	}
}