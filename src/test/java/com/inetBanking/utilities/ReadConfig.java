package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	public ReadConfig() {
		File srcFile=new File("./Configurations/config.properties");
		try {
			FileInputStream fis = new FileInputStream(srcFile);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
			
			System.out.println("Exception is"+e.getMessage());
		}
		
	}
	
	public String getApplicationURL() {
		String urlString = pro.getProperty("baseURL");
		return urlString;
	}
	
	public String getUserName() {
		String uNameString = pro.getProperty("username");
		return uNameString;
	}
	
	public String getPassword() {
		String pwdString = pro.getProperty("password");
		return pwdString;
	}
	
	public String getChromePath() {
		String chromeString = pro.getProperty("chromepath");
		return chromeString;
	}
	
	public String getFirePath() {
		String fireString = pro.getProperty("firepath");
		return fireString;
	}
	
	public String getiePath() {
		String ieString = pro.getProperty("iepath");
		return ieString;
	}
	
	
	
	
	
}
