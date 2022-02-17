package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;

	public AddCustomerPage(WebDriver rDriver) {
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);

	}

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddCustomer;

	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;

	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement rdGender;

	@FindBy(how = How.ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement txtdob;

	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtAddress;

	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtCity;

	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement txtState;

	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtPin;

	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txtMobile;

	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtPwd;

	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement btnSubmit;

	// Adding the action methods below

	public void clickAddCustomer() {
		lnkAddCustomer.click();
	}

	public void customerName(String customerName) {
		txtCustomerName.sendKeys(customerName);
	}

	public void custGender() {
		rdGender.click();
	}

	public void custdob(String mm, String dd, String yyyy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yyyy);
	}

	public void custAddress(String cAddress) {
		txtAddress.sendKeys(cAddress);
	}
	
	public void custCity(String cCity) {
		txtCity.sendKeys(cCity);
	}
	
	public void custState(String cState) {
		txtState.sendKeys(cState);
	}
	
	public void custPin(String cPin) {
		txtPin.sendKeys(cPin);
		
	}
	public void custMobile(String cMobile) {
		txtMobile.sendKeys(cMobile);
	}
	
	public void custEmail(String cEmail) {
		txtEmail.sendKeys(cEmail);
	}
	
	public void custPassword(String cPwd) {
		txtPwd.sendKeys(cPwd);
	}
	
	public void custSubmit() {
		btnSubmit.click();
	}
	
	
}
