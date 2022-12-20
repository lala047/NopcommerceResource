package com.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageobjects.LoginPage;
import com.testBase.BaseClass;
import com.utilities.DataProviders;

public class TC_005_DDT extends BaseClass{

	
	//@Test(dataProvider="LoginData",groups={"master"})
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void loginTestDDt(String user,String pwd,String exp) throws InterruptedException
	{
		logger.info("*******   Starting TC_LoginDDT_002 *******");
		
		//driver.get(configPropObj.getProperty("baseURL"));
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(user);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		String exp_title="Dashboard / nopCommerce administration";
		String act_title=driver.getTitle();
		
		if(exp_title.equals(act_title))
		{
			if(exp.equals("Pass"))
			{
				logger.info("****** login test passed *****");
				lp.clickLogout();
				Thread.sleep(3000);
				Assert.assertTrue(true);
			}
			else if(exp.equals("Fail"))
			{
				logger.info("****** login test failed *****");
				lp.clickLogout();
				Thread.sleep(3000);
				Assert.assertTrue(false);
			}
			
		else if(!exp_title.equals(act_title))
			{
				if(exp.equals("Pass"))
				{
					logger.warn("***** login failed *****");
					Assert.assertTrue(false);
				}
				else if(exp.equals("Fail"))
				{
					logger.info("***** login passed *****");
					Assert.assertTrue(true);
				}
			}
			
		}
		
		
		logger.info("*******  Finished TC_LoginDDT_002 ********");
	}
	
}