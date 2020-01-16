package com.assignment.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.amazon.Amazon;
import com.flipkart.Flipkart;
import com.tripadvisor.Tripadvisor;

public class Testcases 
{
	@Test(priority=1,description="Assigment1 Iphone price",enabled=false)
	void Assignment1()
	{
		WebDriver driver=new ChromeDriver();
		Amazon amazon=PageFactory.initElements(driver, Amazon.class);
		amazon.initializeWebDriver(driver);
		amazon.Navigate("https://www.amazon.in");
		amazon.searchItem("iPhone XR (64GB) - Yellow");
		int amazon_price=amazon.getIphonePrice();
		
		//for flipkart's price
		
		Flipkart flipkart=PageFactory.initElements(driver, Flipkart.class);
		flipkart.initializeWebDriver(driver);
		flipkart.Navigate("https://www.flipkart.com");
		flipkart.searchItem("iPhone XR (64GB) - Yellow");
		int flipkart_price=flipkart.getIphonePrice();
		if(amazon_price<flipkart_price)
		{
			System.out.println("amazon has less price");
		}else {
			System.out.println("flipkart has less price");
		}
		driver.close();
		
	}
	@Test(priority=2,description="Assigment2 Tripadvisor")
	void Assignment2()
	{
		WebDriver driver=new ChromeDriver();
		Tripadvisor tripadvisor=PageFactory.initElements(driver, Tripadvisor.class);
		tripadvisor.initializeWebDriver(driver);
		tripadvisor.Navigate("https://www.tripadvisor.in");
		tripadvisor.searchItem("Club Mahindra");
		tripadvisor.Review();
	}
		
}
