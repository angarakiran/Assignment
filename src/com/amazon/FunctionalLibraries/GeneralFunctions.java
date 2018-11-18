package com.amazon.FunctionalLibraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralFunctions {
	
	private String value;
	WebDriverWait driverWait;
	
	//FUNCTION TO RETRIEVE VALUE FROM PROPERTY FILE
	public String retrieveFromPropFile(String propFile, String key)
	{
		//INSTANCE OF PROPERTY FILE
		Properties prop = new Properties();
		String propFilename = propFile;
		try {
			//LOAD THE PROPERTY FILE
			InputStream inputstream = new FileInputStream(propFilename);
			prop.load(inputstream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//RETURN THE VALUE OF THE KEY	       
		this.value = prop.getProperty(key);
		return value;
	}

	//FUNCTION TO LOGIN TO THE APPLICATION
	public void login(WebDriver driver, String userId, String pwd){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driverWait = new WebDriverWait(driver, 30);
		driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("ap_email")));
		
		//CLEAR ALL OLD DATA FROM THE FIELD AND INPUT THE VALUES
		driver.findElement(By.id("ap_email")).clear();
		driver.findElement(By.id("ap_email")).sendKeys(userId);
		driver.findElement(By.id("ap_password")).clear();
		driver.findElement(By.id("ap_password")).sendKeys(pwd);
		
				
		//CLICK ON BONNECT BUTTON
		try {
			Thread.sleep(2000);
			driver.findElement(By.id("signInSubmit")).click();
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void logout(WebDriver driver){
		driverWait = new WebDriverWait(driver, 30);
		driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='nav-text']")));
		
		//CLICK ON LOGOUT BUTTON
		driver.findElement(By.xpath("//span[@class='nav-text']")).click();
		driver.quit();
		
	}
}



