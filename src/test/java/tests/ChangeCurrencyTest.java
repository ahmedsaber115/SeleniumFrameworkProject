package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {
	HomePage homeobject;
	SearchPage searchobject ;
	String productName = "Apple MacBook Pro 13-inch";
	ProductDetailsPage detailedObject;

	
	@Test(priority = 1)
	public void usercanchangecurrency() 
	{
		homeobject=new HomePage(drive);
		homeobject.changecurrency();
	}
	
	@Test(priority = 2)
	public void searchtest () 
	{
		searchobject = new SearchPage(drive);
		searchobject.productSearch(productName);
		searchobject.OpenPruductDetalidPage();
		detailedObject=new ProductDetailsPage(drive);
		Assert.assertTrue(drive.findElement(detailedObject.currentproduct).getText().equalsIgnoreCase(productName));
		Assert.assertTrue(drive.findElement(detailedObject.pricelabel).getText().contains("€"));
		
	}  
	
	
}
