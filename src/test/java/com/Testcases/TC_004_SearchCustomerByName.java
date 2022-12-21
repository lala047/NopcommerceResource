package com.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageobjects.CustomerPage;
import com.pageobjects.LandingPage;
import com.pageobjects.LoginPage;
import com.testBase.BaseClass;

public class TC_004_SearchCustomerByName extends BaseClass{
	
	@Test (groups={"master"})
	public void searchCustomerbyName() {

		LoginPage lp= new LoginPage(driver);
		lp.SetLogin("admin@yourstore.com","admin");
		//lp.SetLogin("email","password");
		LandingPage ld= new LandingPage(driver);
		
		ld.createcustomer();
		CustomerPage cp=new CustomerPage(driver);
		cp.setFirstName("Victoria");
		cp.setLastName("Terces");
		cp.clickSearch();
		
	boolean status=cp.searchCustomerByName("Victoria Terces");  // A method (searchCustomerByEmail) was created using For Loop to search if the email actually exists in the table in the CustomerPage
	if(status==true)				
		{
		Assert.assertTrue(true);
}
}
}