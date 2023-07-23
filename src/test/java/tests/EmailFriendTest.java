package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase {
	// user register
	// search for product
	// email friend
	// logout
	HomePage homeobject;
	UserRegistrationPage registobject ;
	LoginPage loginobject;
	EmailFriendPage emailfriendobject;
	SearchPage searchobject ;
	String searchtext="MacB";
	String productName = "Apple MacBook Pro 13-inch";
	ProductDetailsPage detailedObject;
	String frindmail = "mail1500162224@gmail.com";
	String personalmessage = "what is your fav product";

	@Test(priority = 1)
	public void UserCanRegisterSuccsessfully() throws InterruptedException 
	{
		homeobject=new HomePage(drive);
		homeobject.openUserRegistrationPage();
		registobject=new UserRegistrationPage(drive); 
		registobject.userRegistration("ahmed", "saber","kk9kkssut488012@gmail.com" , "123456789");
		Assert.assertTrue(drive.findElement(registobject.successMessage).getText().contains("Your registration completed"));	
	}
	@Test(priority = 2)
	public void RegisterUserCanLogin() 
	{
		homeobject.openLoginPage();
		loginobject=new LoginPage(drive);
		loginobject.UserLogin("kk9kkssut488012@gmail.com", "123456789");
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
	public void usercanemailfriend () 
	{
		detailedObject = new ProductDetailsPage(drive);
		detailedObject.OpenemailfriendPage();
		emailfriendobject = new EmailFriendPage(drive);
		emailfriendobject.emailfriend(frindmail, personalmessage);
		Assert.assertTrue(drive.findElement(emailfriendobject.successmsg).getText().contains("has been sent"));
	}

	@Test(priority = 5)
	public void RegisterUserCanLogout () 
	{
		registobject.UserLogout();
	}

}
