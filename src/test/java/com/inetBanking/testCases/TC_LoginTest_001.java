
package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void LoginTest() throws IOException {
	
		logger.info("The URL is opened");
		
		LoginPage LP = new LoginPage(driver);
		LP.setUserName(username);
		logger.info("Entered username");
		
		LP.setPassword(password);
		logger.info("Entered password");
		
		LP.clickSubmit();
		logger.info("Submit button is clicked");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login test case passed");
		}
		else {
			captureScreen(driver,"LoginTest"); // The Screen capture method is called in the test case
			Assert.assertTrue(false);
			logger.info("Login test case failed");
		}
	
	
	}
	
}
