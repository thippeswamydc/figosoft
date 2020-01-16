package com.amazon;

import java.sql.Driver;
import java.sql.Time;
import com.utility.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon 
{
	private WebDriver driver;
	@FindBy(how=How.XPATH,using="//div[@data-cel-widget='search_result_2']//child::span[@class='a-price-whole']")
	private WebElement price;
	@FindBy(how=How.ID,using="twotabsearchtextbox")
	private WebElement searchbarElement;
	@FindBy(how=How.XPATH,using="//input[@class='nav-input' and @value='Go']")
	private WebElement searchBtnElement;
	

	public void initializeWebDriver(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void Navigate(String webString)
	{
		driver.navigate().to(webString);
		driver.manage().window().maximize();
	}
	public int getIphonePrice()
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(price));
		//System.out.println("Amazon's price is "+price.getText());
		System.out.println("Amazon's price is after conversion "+Utitlity.parseStringToInt(price.getText()));
		return Utitlity.parseStringToInt(price.getText());
	}
	public void searchItem(String searchitem)
	{
		WebDriverWait wait=new WebDriverWait(driver,10 );
		wait.until(ExpectedConditions.visibilityOf(searchbarElement));
		searchbarElement.sendKeys(searchitem);
		wait.until(ExpectedConditions.elementToBeClickable(searchBtnElement));
		searchBtnElement.click();
		
	}
	
	

}
