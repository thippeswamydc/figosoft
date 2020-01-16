package com.tripadvisor;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tripadvisor 
{
	@FindBy(how=How.XPATH,using="//div[@class='brand-global-nav-action-search-Search__searchButton--b9-IK brand-global-nav-action-search-Search__grayOutline--3DjHN']")
	WebElement searchbarclkElement;
	WebDriver driver;
	@FindBy(how=How.XPATH,using="//div[@class='scopedSearchDisplay staticPOIDisplay']//following::li")
	WebElement suggestElement;
	@FindBy(how=How.XPATH,using="//input[@id='mainSearch']")
	WebElement searchbarElement;
	@FindBy(how=How.XPATH,using="//a[@href='#REVIEWS' and @class='hotels-hotel-review-atf-info-parts-Rating__ratingsAnchor--28rqA']")
	WebElement reviewlinkElement;
	@FindBy(how=How.CSS,using="div.hotels-community-content-common-ContextualCTA__currentOption--3Wd5D")
	WebElement writereviewbtnElement;
	@FindBy(how=How.ID,using="ReviewTitle")
	WebElement titleElement;
	@FindBy(how=How.ID,using="ReviewText")
	WebElement reviewTextElement;
	public void initializeWebDriver(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void Navigate(String webString)
	{
		driver.navigate().to(webString);
		driver.manage().window().maximize();
	}
	public void searchItem(String searchitem)
	{
		WebDriverWait wait=new WebDriverWait(driver,10 );
		wait.until(ExpectedConditions.visibilityOf(searchbarclkElement));
		searchbarclkElement.click();		
		wait.until(ExpectedConditions.visibilityOf(searchbarElement));
		searchbarElement.sendKeys(searchitem);
		wait.until(ExpectedConditions.visibilityOf(suggestElement));
		List<WebElement> listofsuggestsElements=driver.findElements(By.xpath("//div[@class='scopedSearchDisplay staticPOIDisplay']//child::li"));
		System.out.println(listofsuggestsElements.size());
		listofsuggestsElements.get(0).click();
	}
	public void Review()
	{
		WebDriverWait wait=new WebDriverWait(driver,10 );
		
		wait.until(ExpectedConditions.visibilityOf(reviewlinkElement));
		reviewlinkElement.click();	
		wait.until(ExpectedConditions.visibilityOf(writereviewbtnElement));
		writereviewbtnElement.click();
		//switch window
		String mainwindowString=driver.getWindowHandle();
		Set<String> windowStrings=driver.getWindowHandles();
		System.out.println(windowStrings.size());
		windowStrings.remove(mainwindowString);
		String writereviewWindowString=windowStrings.iterator().next();
		driver.switchTo().window(writereviewWindowString);
		RatenWrite();
		
		
	}
	public void RatenWrite()
	{
		WebDriverWait wait=new WebDriverWait(driver,10 );
		WebElement ratinghoverElement=driver.findElement(By.cssSelector("#bubble_rating"));
		wait.until(ExpectedConditions.visibilityOf(ratinghoverElement));
		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(By.cssSelector("#bubble_rating"))).build().perform();
		titleElement.sendKeys("some random title text");
		reviewTextElement.sendKeys("some random review text");
		
	}
}
