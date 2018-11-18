package com.amazon.Login;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.AddToCart.SearchAddToCart;
import com.amazon.FunctionalLibraries.GeneralFunctions;

public class LoginPage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	public String PriceOfProduct=null;
	
	/*String url,loc;
	String loginProp = "src/com/amazon/resources/LoginDetails.properties";*/
	
	@BeforeTest
	public void init(){
		System.setProperty("webdriver.gecko.driver","C:\\Libraries\\Selenium\\geckodriver-v0.22.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.amazon.com");
		System.out.println("Launching the Browser and maximizing the browser window");
		driver.manage().window().maximize();
		String WSTitle=driver.getTitle();
		System.out.println("Title of the WEBPAGE" + WSTitle);
		WebDriverWait wait=new WebDriverWait(driver,20);
		//Object creation for the SearchAddToCart class and accessing the methods
		SearchAddToCart s=new SearchAddToCart();
		s.search(driver,wait); //Method to search for the Digital Cameras 
		s.listofElements(driver, wait); //Method to fetch the list of Digital Cameras and selecting the 5th Camera
		float[] result=s.AddtoCart(driver);
		s.Total(result[0], result[1]); //Method which calculate the sum of the products which are added to Cart 
		System.out.println("Closing the session");
		driver.close();// Quit the session
		
}
	
/*===============================================================================================
LOGIN FUNCTIONALITY
	@BeforeMethod
	public void login() {
		//INSTANCE FOR FILE LOGGING USING LOG4J
		GeneralFunctions config=new GeneralFunctions();
		String log4jConfPath="log4j.properties";
		PropertyConfigurator.configure(log4jConfPath); 
			 
		//RETRIEVING THE VALUE OF URL, USERID AND PWD
		String userId = config.retrieveFromPropFile(loc+loginProp, "adminUserId");
		String password = config.retrieveFromPropFile(loc+loginProp, "adminPwd");
		
		
		//LOGIN
		config.login(driver, userId, password);
	}*/

/*===========================================================================================================
LOGOUT FUNCTIONALITY
	@AfterMethod
	public void logout() {
		//LOGOUT
		GeneralFunctions config=new GeneralFunctions();
		config.logout(driver);
		
	}*/
	
}
