package com.flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utility.Utitlity;

public class Flipkart {
	 
	private WebDriver driver;
	@FindBy(how=How.XPATH,using="//div[@class='_1vC4OE _2rQ-NK']")
	private WebElement price;
	@FindBy(how=How.XPATH,using="//div[@class='col-12-12 _2tVp4j']//input[@name='q']")
	private WebElement searchbarElement;
	@FindBy(how=How.XPATH,using="//button[@class='vh79eN' and @type='submit']")
	private WebElement searchBtnElement;
	@FindBy(how=How.XPATH,using="//button[@class='_2AkmmA _29YdH8']")
	WebElement loginCancelbtnElement;

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
		String price2;
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(price));
		price2=price.getText();
		//System.out.println("Flipkart's price is "+price2);
		System.out.println("Flipkart's price is  after conversion "+Utitlity.parseStringToInt(price2.substring(1)));
		return Utitlity.parseStringToInt(price2.substring(1));
		
		
	}
	public void searchItem(String searchitem)
	{
		
		WebDriverWait wait=new WebDriverWait(driver,10 );
		wait.until(ExpectedConditions.visibilityOf(loginCancelbtnElement));
		wait.until(ExpectedConditions.visibilityOf(searchbarElement));
		loginCancelbtnElement.click();
		searchbarElement.sendKeys(searchitem);
		wait.until(ExpectedConditions.elementToBeClickable(searchBtnElement));
		searchBtnElement.click();
	}
	
}
