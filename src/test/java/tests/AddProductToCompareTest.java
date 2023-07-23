package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CompareProductPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCompareTest extends TestBase {
	
	SearchPage searchobject ;
	String searchtext1="MacB";
	String searchtext2="Asus";
	String firstproductName = "Apple MacBook Pro 13-inch";
	String secondproductName = "Asus N551JK-XO076H Laptop";
	ProductDetailsPage detailedObject;
	CompareProductPage compareobject ;
	
	@Test (priority = 1)
	public void UserCanCompareProducts() throws InterruptedException 
	{
		searchobject=new SearchPage(drive);
		searchobject.productsearchUsingAutoSugg(searchtext1);
		detailedObject=new ProductDetailsPage(drive);
		compareobject=new CompareProductPage(drive);
		Assert.assertTrue(drive.findElement(detailedObject.currentproduct).getText().equalsIgnoreCase(firstproductName));
		detailedObject.addProductToCompare();
		
		
		searchobject.productsearchUsingAutoSugg(searchtext2);
		Assert.assertTrue(drive.findElement(detailedObject.currentproduct).getText().equalsIgnoreCase(secondproductName));
		detailedObject.addProductToCompare();
	
		Thread.sleep(1000);
		
		drive.navigate().to("https://demo.nopcommerce.com/compareproducts");
		compareobject.PtoductCompare();  
	}
	
	@Test(priority = 2)
	public void userCanClearCompareList () 
	{
		compareobject.Clearwishlist();
		Assert.assertTrue(drive.findElement(compareobject.nodatamssg).getText().contains("You have no items to compare"));

	}
	
	
	
}
