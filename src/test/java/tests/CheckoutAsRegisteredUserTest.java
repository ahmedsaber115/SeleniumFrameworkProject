package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductInformationPage;
import pages.SearchPage;
import pages.ShoppingCardPage;
import pages.UserRegistrationPage;
public class CheckoutAsRegisteredUserTest extends TestBase{
	HomePage homeobject;
	UserRegistrationPage registobject ;
	LoginPage loginobject;
	SearchPage searchobject ;
	String searchtext="MacB";
	String productName = "Apple MacBook Pro 13-inch";
	ProductDetailsPage detailedObject;
	ShoppingCardPage shoppingcartobject;
	CheckoutPage checkobject;
	ProductInformationPage informationobject ;
	


	@Test(priority = 1)
	public void UserCanRegisterSuccsessfully() throws InterruptedException 
	{
		homeobject=new HomePage(drive);
		homeobject.openUserRegistrationPage();
		registobject=new UserRegistrationPage(drive); 
		registobject.userRegistration("ahmed", "saber","saulolffkjon52361@gmail.com" , "123456789");
		Assert.assertTrue(drive.findElement(registobject.successMessage).getText().contains("Your registration completed"));	
	}
	@Test (priority = 2)
	public void RegisterUserCanLogin() 
	{
		homeobject.openLoginPage();
		loginobject=new LoginPage(drive);
		loginobject.UserLogin("saulolffkjon52361@gmail.com", "123456789");
		Assert.assertTrue(drive.findElement(registobject.logoutlink).getText().contains("Log out"));
	}
	@Test(priority = 3)
	public void searchwithautosugg () throws InterruptedException
	{
		searchobject=new SearchPage(drive);
		searchobject.productsearchUsingAutoSugg(searchtext);
		detailedObject=new ProductDetailsPage(drive);
		Assert.assertTrue(drive.findElement(detailedObject.currentproduct).getText().equalsIgnoreCase(productName));
	}
	@Test (priority = 4)
	public void addTocartAndOpenShoppingCard () throws InterruptedException 
	{
		detailedObject=new ProductDetailsPage(drive);
		detailedObject.addToCart();
		detailedObject.OpenShoppingCartPage();
	}

	@Test(priority = 5)
	public void openCeckoutPage () 
	{
		shoppingcartobject=new ShoppingCardPage(drive);
		shoppingcartobject.openCheckoutPage();
	}
	
	@Test(priority = 6)
	public void ceckoutTest() throws InterruptedException 
	{
		checkobject=new CheckoutPage(drive);
		checkobject.RegisterUserCanCheckoutProduct("Egypt", "Cairo", "Test adress", "123458", "12597745");
		Assert.assertTrue(drive.findElement(checkobject.succMSG).getText().contains("successfully processed"));
	}
	@Test(priority =7 )
	public void usercanPrintanDowloadPDFInvoiceTest () throws InterruptedException 
	{
		checkobject=new CheckoutPage(drive);
		checkobject.OpenInformationPage();
		informationobject =new ProductInformationPage(drive);
		informationobject.printaoarderDetails();
		informationobject.DownloadPDFInvoice();
	}





}
