package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends PageBase  {

	public SearchPage(WebDriver drive) {
		super(drive);
	}
	By searchtextbox = By.id("small-searchterms");
	
	By searchBTN = By.cssSelector("button.button-1.search-box-button");
	
	By productList = By.id("ui-id-1");
	
	
	By productTitle = By.linkText("Apple MacBook Pro 13-inch");
	
	public void productSearch(String productName) 
	{
		setTextElementText(searchtextbox, productName);
		clickButton(searchBTN);
	}
	
	public void OpenPruductDetalidPage() 
	{
		clickButton(productTitle);
	}
	
	// test case other method
	
	public void productsearchUsingAutoSugg(String searchtext) throws InterruptedException 
	{
		setTextElementText(searchtextbox, searchtext);
		Thread.sleep(3000);
		drive.findElements(productList).get(0).click();
	
		
	}




}
