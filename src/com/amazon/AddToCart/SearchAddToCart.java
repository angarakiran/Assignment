package com.amazon.AddToCart;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.amazon.Login.LoginPage;
import com.amazon.ObjectRepository.SearchAddToCartRepo;

public class SearchAddToCart implements SearchAddToCartRepo{
	
	
	@Test
	public void search(WebDriver driver, WebDriverWait wait)
	{
		
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idSearchTextBox)));
		System.out.println("I am searching for the Best Digital Cameras");
		element.sendKeys("Best sellers in Digital Cameras");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.className("nav-input")).click();
	}
	public void listofElements(WebDriver driver,WebDriverWait wait)
	{	
		int fifth=4;
		WebElement value=null;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		List<WebElement> allLinks = driver.findElements(By.xpath(xpathListOfProducts));
		System.out.println(allLinks.size());
		Iterator<WebElement> itr = allLinks.iterator();
		for(int i = 0; itr.hasNext(); i++) 
		{
		    value = itr.next();
		  	if (i == fifth)
		  	{
		        value.click();
		        System.out.println(driver.getTitle());
		        break;
		    }
		}
}
	public float[] AddtoCart(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String DropdownTitle=driver.findElement(By.xpath(xpathDropDownTitle)).getText();
		System.out.println("Title of Drop down to select the Quantities" + DropdownTitle);
		String PriceOfProduct=driver.findElement(By.xpath(xpathPriceOfProduct)).getText();
		System.out.println("Fetching the price of the Product" + PriceOfProduct);
		Select Items_Quantity=new Select(driver.findElement(By.name(nameDropDown)));
		int Max_Quantity=Items_Quantity.getOptions().size();
		System.out.println(Max_Quantity);
		if(Max_Quantity>=8)
		{
		Items_Quantity.selectByVisibleText("8");
		driver.findElement(By.xpath(xpathAddToCartButton)).click();
		}
		else 
		{
			System.out.println("Select the Maximum number of products to the Cart. If stock is less than 8");
			Items_Quantity.selectByVisibleText(String.valueOf(Max_Quantity));
			driver.findElement(By.xpath(xpathAddToCartButton)).click();
		}
		
		float[] result=new float[2];
		System.out.println("Quantity and price of product : "+Max_Quantity+" "+PriceOfProduct);
		result[0]=Max_Quantity;
		result[1]=Float.parseFloat(PriceOfProduct.replace("$",""));
		return(result);
	}
	public void Total(float Max_Quantity,float PriceOfProduct)
	{
		System.out.println("Caluculating total Cart Value");
		float total=Max_Quantity*PriceOfProduct;
		System.out.println("$"+total);
	}
}
