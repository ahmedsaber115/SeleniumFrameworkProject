package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoSugg extends TestBase {
	SearchPage searchobject ;
	String searchtext="MacB";
	String productName = "Apple MacBook Pro 13-inch";
	ProductDetailsPage detailedObject;
	
	@Test
	public void searchwithautosugg () throws InterruptedException
	{
		searchobject=new SearchPage(drive);
		searchobject.productsearchUsingAutoSugg(searchtext);
		detailedObject=new ProductDetailsPage(drive);
		Assert.assertTrue(drive.findElement(detailedObject.currentproduct).getText().equalsIgnoreCase(productName));
	}


}
