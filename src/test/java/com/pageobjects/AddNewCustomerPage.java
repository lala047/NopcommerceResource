package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage extends BasePage{
		
		public AddNewCustomerPage(WebDriver driver) {
			
			super(driver);
			}
				
		@FindBy(xpath="//input[@id='Email']") public WebElement txtEmail;
		@FindBy(xpath="//input[@id='Password']") public WebElement txtpwd;
		@FindBy(xpath="//input[@id='FirstName']") public WebElement txtfname;
		@FindBy(xpath="//input[@id='LastName']") public WebElement txtlname;
		@FindBy(xpath="//input[@id='Gender_Male']") public WebElement rdMaleGender;
		@FindBy(xpath="//input[@id='Gender_Female']") public WebElement rdFemaleGender;
		@FindBy(xpath="//input[@id='DateOfBirth']") public WebElement txtdob;
		@FindBy(xpath="//input[@id='Company']") public WebElement txtcompanyname;
		@FindBy(xpath="//div[@class='input-group-append input-group-required']//div[@role='listbox']") public WebElement txtcustomerroles;
		@FindBy(xpath="//span[@title='delete']") public WebElement deletedefaultRegistered;	 // This will remove the 'Registered' that is there before anything can be selected
		@FindBy(xpath="//li[contains(text(),'Administrators')]") public WebElement lstitemAdministrators;
		@FindBy(xpath="//li[contains(text(),'Forum Moderators')]") public WebElement lstitemForumModerators;
		@FindBy(xpath="//li[contains(text(),'Guests')]") public WebElement lstitemGuests;
		@FindBy(xpath="//li[contains(text(),'Registered')]") public WebElement lstitemRegistered;
		@FindBy(xpath="//li[contains(text(),'Vendors')]") public WebElement lstitemVendors;
		@FindBy(xpath="//textarea[@id='AdminComment']") public WebElement txtAdminContent;
		@FindBy(xpath="//select[@id='VendorId']") public WebElement drpmgrOfVendors;
		@FindBy(xpath="//button[@name='save']") public WebElement btnSave;
		@FindBy(xpath="//textarea[@id='AdminComment']") public WebElement admincomment;
		@FindBy(xpath="//button[@name='save']//i[@class='far fa-save']") public WebElement btnsave;
		
		
		
		//Action methods
				
	
				
				public void setEmail(String email){
				txtEmail.sendKeys(email);
				}
				
				public void setPassword(String password){
					txtpwd.sendKeys(password);
				}
				
				public void setFirstName(String fname){
					txtfname.sendKeys(fname);
				}
				
				public void setLastName(String lname){
					txtlname.sendKeys(lname);
				}
				public void setGender(String gender){
					if(gender.equals("Male")){
						rdMaleGender.click();
					}
					else if(gender.equals("Female")){
						rdFemaleGender.click();
					}else{
						rdMaleGender.click();//Default
					}
				}
					public void setDob(String dob){
						txtdob.sendKeys(dob);
					}
					public void setCompanyName(String comname){
						txtcompanyname.sendKeys(comname);
					}
					public void setCustomerRoles(String role) throws InterruptedException {		
						deletedefaultRegistered.click();
						txtcustomerroles.click();
						
						Thread.sleep(3000);
						if(role.equals("Guests"))
						{
							
							lstitemGuests.click();
						}
						else if(role.equals("Vendors"))
						{
						     lstitemVendors.click();
						}
						else if(role.equals("Administrators"))
						{
							lstitemAdministrators.click(); 
						}
						else if(role.equals("Forum Moderators"))
						{			
							lstitemForumModerators.click(); 
						}
						else
						{
							System.out.println("Default option is Registered role");
						}
					
						}
					public void SetManagerofvendor(String value) {
						Select dp=new Select(drpmgrOfVendors);
						dp.selectByVisibleText(value);
						
					}
					public void setAdminComment(String comment) {
						admincomment.sendKeys(comment);
					}
					public void clickOnSave() {
						btnsave.click();
						
}
}



