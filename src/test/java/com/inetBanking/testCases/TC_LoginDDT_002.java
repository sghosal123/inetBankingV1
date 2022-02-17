package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLutils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider ="LoginData")
	public void loginDDT(String user, String pwd) {
		LoginPage LP = new LoginPage(driver);
		LP.setUserName(user);
		logger.info("user name is provided");
		LP.setPassword(pwd);
		logger.info("password is provided");
		LP.clickSubmit();
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();// close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		}
		else {
			Assert.assertTrue(true);
			logger.info("Login passed");
			LP.clickLogout();
			driver.switchTo().alert().accept();// close the logout alert
			driver.switchTo().defaultContent();
		}
		

	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;

		}
	}

	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException {
		String pathString="C:/Users/sghosal/eclipse-workspace/inetBankingV1/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		int rownum = XLutils.getRowCount(pathString,"Sheet1");
		int colcount = XLutils.getCellCount(pathString,"Sheet1",1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLutils.getCellData(pathString, "Sheet1", i, j);
			}
		}
		return logindata;
	}

}
