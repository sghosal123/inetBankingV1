package com.inetBanking.testCases;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	

	ReadConfig readConfig = new ReadConfig();
		
	public String baseURL=readConfig.getApplicationURL();
	public String username=readConfig.getUserName();
	public String password=readConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
				
		logger=Logger.getLogger(BaseClass.class);
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());		
		driver = new ChromeDriver();
		}
		else if(br.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver",readConfig.getFirePath());		
			driver = new FirefoxDriver();
		}
		else if(br.equals("IE")){
			System.setProperty("webdriver.ie.driver",readConfig.getiePath());		
			driver = new InternetExplorerDriver();
		}
		driver.get(baseURL);
		driver.manage().window().maximize();		
	}
	


	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File taFile = new File(System.getProperty("user.dir")+"/ScreenShots/"+tName+".png");
		FileUtils.copyFile(srcFile, taFile);
		System.out.println("Screen Shot Taken");
		}
	
	
	public String RandomeNumberGenerate() {
		
		String genString = RandomStringUtils.randomAlphanumeric(8);
		return genString;
	}
		
	}
	

