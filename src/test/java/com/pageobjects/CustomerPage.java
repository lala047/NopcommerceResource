package com.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerPage extends BasePage{
	
	public CustomerPage(WebDriver driver) {
		
		super(driver);
		}
			
	@FindBy(xpath="//a[normalize-space()='Add new']") public WebElement addnewbtn;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissable']") public WebElement txtmsg; //the message showing new customer was successfully added
	@FindBy(xpath="//input[@id='SearchEmail']") public WebElement txtemailsearch;
	@FindBy(xpath="//button[@id='search-customers']") public WebElement btnsearch;
	@FindBy(xpath="//table[@id='customers-grid']/tbody/tr[\"+i+\"]/td[2]") public WebElement txtcustemailadd;  // This means that the email of interest is in the 2nd column(td[2] and also the tr was not hardcoded(i+i)
	@FindBy(xpath = "//table[@id='customers-grid']") public WebElement table;
	@FindBy(xpath= "//table[@role='grid']")public WebElement tblSearchResults;   
	@FindBy(xpath = "//table[@id='customers-grid']//tr") List<WebElement> tableRows; 
	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr/td") List<WebElement> tableColumns;    
	@FindBy(xpath="//table[@id='customers-grid']/tbody/tr[\"+i+\"]/td[2]") public WebElement txtcustname;
	@FindBy(id = "SearchEmail")WebElement txtEmail;
	@FindBy(id = "SearchFirstName")public WebElement txtFirstName;
	@FindBy(id= "SearchLastName")public WebElement txtLastName;

 
	
	
	
	public void clickOnAddnew() {
		addnewbtn.click();

	}
	public boolean verifyConfirmationMsg()
	{
		String msg=txtmsg.getText();
		if (msg.contains("The new customer has been added successfully"))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	public void setEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	public void setFirstName(String fname) {

		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {

		txtLastName.clear();
		txtLastName.sendKeys(lname);
	}

	public void clickSearch() {
		btnsearch.click();

	}
	
	public int getNoOfRows() {
		return (tableRows.size());
	}

	public int getNoOfColumns() {
		return (tableColumns.size());
	}

	
	public boolean searchCustomerByEmail(String email) { // Method to locate customer by email
		boolean flag = false;

		for (int i = 1; i <= getNoOfRows(); i++) {
			String emailid = txtcustemailadd.getText();

			System.out.println(emailid);

			if (emailid.equals(email)) {
				flag = true;
				break;
			}
		}

		return flag;
			
		}	
		


public boolean searchCustomerByName(String Name) {  // Method to locate customer by name
	boolean flag = false;

	for (int i = 1; i <= getNoOfRows(); i++) {
		String name = txtcustname.getText();
		
		if (Name.equals(name)) {
			flag = true;
			break;
		}
	}

	return flag;

}

}