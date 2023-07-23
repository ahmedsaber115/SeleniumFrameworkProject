package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class ProductReviewTest extends TestBase {
	HomePage homeobject;
	UserRegistrationPage registobject ;
	LoginPage loginobject;
	SearchPage searchobject ;
	String searchtext="MacB";
	String productName = "Apple MacBook Pro 13-inch";
	ProductDetailsPage detailedObject;
	ProductReviewPage reviewobject;
	
	String reviewTitle = "usage of pruduct";
	String ReviewText = "good product";
	
	@Test(priority = 1)
	public void UserCanRegisterSuccsessfully() throws InterruptedException 
	{
	homeobject=new HomePage(drive);
	homeobject.openUserRegistrationPage();
	registobject=new UserRegistrationPage(drive); 
	registobject.userRegistration("ahmed", "saber","n50050044@gmail.com" , "123456789");
	Assert.assertTrue(drive.findElement(registobject.successMessage).getText().contains("Your registration completed"));	
	}
	@Test(priority = 2)
	public void RegisterUserCanLogin() 
	{
		homeobject.openLoginPage();
		loginobject=new LoginPage(drive);
		loginobject.UserLogin("n50050044@gmail.com", "123456789");
		Assert.assertTrue(drive.findElement(registobject.logoutlink).getText().contains("Log out"));
	}
	@Test (priority = 3)
	public void searchwithautosugg () throws InterruptedException
	{
		searchobject=new SearchPage(drive);
		searchobject.productsearchUsingAutoSugg(searchtext);
		detailedObject=new ProductDetailsPage(drive);
		Assert.assertTrue(drive.findElement(detailedObject.currentproduct).getText().equalsIgnoreCase(productName));
	}
	
	@Test (priority = 4)
	public void userCanReviewProduct () 
	{
		detailedObject=new ProductDetailsPage(drive);
		detailedObject.openReviewPage();
		reviewobject= new ProductReviewPage(drive);
		reviewobject.productReview(reviewTitle, ReviewText );
		Assert.assertTrue(drive.findElement(reviewobject.succmsg).getText().contains("review is successfully added"));
	}

}
