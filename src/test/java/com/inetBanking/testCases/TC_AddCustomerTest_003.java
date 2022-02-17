package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	@Test
	public void addNewCustomer() throws IOException, InterruptedException {
		LoginPage LP = new LoginPage(driver);
		LP.setUserName(username);
		LP.setPassword(password);
		LP.clickSubmit();

		// Post login to the Login Page
		Thread.sleep(3000);
		AddCustomerPage addcus = new AddCustomerPage(driver);
		addcus.clickAddCustomer();
		addcus.customerName("Sayoni");
		addcus.custGender();
		addcus.custdob("12", "03", "1973");
		addcus.custAddress("Address");
		addcus.custCity("Pune");
		addcus.custState("Maharashtra");
		addcus.custPin("411045");
		addcus.custMobile("9879897766");
		
		String genemail = RandomeNumberGenerate() + "@gmail.com";
		addcus.custEmail(genemail);
		addcus.clickAddCustomer();
		Thread.sleep(3000);
		
		Boolean respBoolean = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (respBoolean == true) {
			Assert.assertTrue(true);
			logger.info("The test case has successfully submitted the data");
		} else {
			Assert.assertTrue(false);
			captureScreen(driver, "TC_AddCustomerTest_003");
			logger.info("The test case is failed");
		}

	}

}
