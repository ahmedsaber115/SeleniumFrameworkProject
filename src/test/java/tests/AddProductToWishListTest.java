package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase {
	SearchPage searchobject ;
	String searchtext="MacB";
	String productName = "Apple MacBook Pro 13-inch";
	ProductDetailsPage detailedObject;
	WishListPage wishlistobject;
	
	
	@Test (priority = 1)
	public void searchwithautosugg () throws InterruptedException
	{
		searchobject=new SearchPage(drive);
		searchobject.productsearchUsingAutoSugg(searchtext);
		detailedObject=new ProductDetailsPage(drive);
		Assert.assertTrue(drive.findElement(detailedObject.currentproduct).getText().equalsIgnoreCase(productName));
	}
	@Test(priority = 2)
	public void addToWshlistTest() throws InterruptedException 
	{
		detailedObject=new ProductDetailsPage(drive);
		detailedObject.openWishlistPage();
	}
	@Test(priority = 3)
	public void removeProduct() 
	{
		wishlistobject= new WishListPage(drive);
		wishlistobject.RemoveWishlistproduct();
		Assert.assertTrue(drive.findElement(wishlistobject.checkwishlistafterremove).getText().contains("The wishlist is empty"));
	}

}
