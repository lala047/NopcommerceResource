package com.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageobjects.AddNewCustomerPage;
import com.pageobjects.CustomerPage;
import com.pageobjects.LandingPage;
import com.pageobjects.LoginPage;
import com.testBase.BaseClass;

public class TC_002_AddNewCustomerTest extends BaseClass{

	
	@Test 
	public void AddnewCustomer() throws InterruptedException {
		LoginPage lp= new LoginPage(driver);
		//lp.SetLogin("admin@yourstore.com","admin");
		lp.setUserName(rb.getString("email"));     //valid email , get it from config.properties   // rb=ResourceBundle.getBundle("config");(This is in the BaseClass and it helps to read the config.properties
		lp.setPassword(rb.getString("password")); // valid password, get it from config.properties
		lp.clickLogin();
		
		
		LandingPage ld= new LandingPage(driver);
		
		ld.createcustomer();
		CustomerPage cp=new CustomerPage(driver);
		cp.clickOnAddnew();
		AddNewCustomerPage addcust= new AddNewCustomerPage(driver);
		addcust.setEmail(randomeString() + "@gmail.com");// randomly generated the email using the method randomeString located in the BaseClass);
		addcust.setPassword(randomeString());  //Password not hard coded
		//addcust.setPassword("Slyman01");   //password hard coded
		addcust.setFirstName(randomeString());
		//addcust.setFirstName("emma");    //hard coded
		addcust.setLastName(randomeString());
		//addcust.setLastName("Ighedo");   //hard coded
		addcust.setGender("Male");
		addcust.setDob("2/12/2004");
		addcust.setCompanyName("lala");
		addcust.setCustomerRoles("Guests");
		addcust.SetManagerofvendor("Vendor 1");
		addcust.setAdminComment("This is Testing");
		addcust.clickOnSave();
		Thread.sleep(5000);
		
		
		//To verify that we landed on the acct page after log in (note: A method is in the MyAccountPage to be able to use this)
				
				boolean targetpage=cp.verifyConfirmationMsg();
				
				try {
					Assert.assertEquals(targetpage,true);
				}
				
				catch(Exception e)
				{
					Assert.fail();
		
		
	
		//OR USE OF PAGE SOURCE TO ASSERT
/*boolean res=driver.getPageSource().contains("The new customer has been added successfully");//just  copy the text(which is any message on the page of interest)and put here
		
		if(res==true)				//We do not rely on any method for this assertion
		{
		Assert.assertTrue(true);
			
		}else{
		Assert.assertTrue(false);
		}*/
		
		}
	}
}
