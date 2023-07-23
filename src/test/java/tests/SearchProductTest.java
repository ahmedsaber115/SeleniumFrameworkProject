package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase {
	SearchPage searchobject ;
	String productName = "Apple MacBook Pro 13-inch";
	ProductDetailsPage detailedObject;

	@Test
	public void searchtest () 
	{
		searchobject = new SearchPage(drive);
		searchobject.productSearch(productName);
		searchobject.OpenPruductDetalidPage();
		detailedObject=new ProductDetailsPage(drive);
		Assert.assertTrue(drive.findElement(detailedObject.currentproduct).getText().equalsIgnoreCase(productName));
	}


}
