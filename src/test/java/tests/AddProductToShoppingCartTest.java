package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCardPage;

public class AddProductToShoppingCartTest extends TestBase{
	SearchPage searchobject ;
	String searchtext="MacB";
	String productName = "Apple MacBook Pro 13-inch";
	ProductDetailsPage detailedObject;
	ShoppingCardPage shoppingcartobject;
	
	@Test (priority = 1)
	public void searchwithautosugg () throws InterruptedException
	{
		searchobject=new SearchPage(drive);
		searchobject.productsearchUsingAutoSugg(searchtext);
		detailedObject=new ProductDetailsPage(drive);
		Assert.assertTrue(drive.findElement(detailedObject.currentproduct).getText().equalsIgnoreCase(productName));
	}
	
	@Test (priority = 2)
	public void addTocartAndOpenShoppingCard () throws InterruptedException 
	{
		detailedObject=new ProductDetailsPage(drive);
		detailedObject.addToCart();
		detailedObject.OpenShoppingCartPage();
	}
	
	@Test (priority = 3)
	public void uptateShoppingcard () 
	{
		shoppingcartobject=new ShoppingCardPage(drive);
		shoppingcartobject.shoppingcartquantityAndUpdate("2");
	}
	
	@Test (priority = 4)
	public void canremoveCart () 
	{
		shoppingcartobject=new ShoppingCardPage(drive);
		shoppingcartobject.shoppingcartRemove();
		Assert.assertTrue(drive.findElement(shoppingcartobject.removemesg).getText().contains("Shopping Cart is empty"));
	}
	

}
