package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {
	
	HomePage homeobject;
	UserRegistrationPage registobject ;
	LoginPage loginobject;
	
	@Test(priority = 1 , alwaysRun = true)
	public void UserCanRegisterSuccsessfully() throws InterruptedException 
	{
	homeobject=new HomePage(drive);
	homeobject.openUserRegistrationPage();
	registobject=new UserRegistrationPage(drive); 
	registobject.userRegistration("ahmed", "saber","makkklportil1557890@gmail.com" , "123456789");
	Assert.assertTrue(drive.findElement(registobject.successMessage).getText().contains("Your registration completed"));
	}
	@Test(dependsOnMethods = "UserCanRegisterSuccsessfully")
	public void RegisterUserCanLogout () 
	{
		registobject.UserLogout();
	}
	@Test (dependsOnMethods = "UserCanRegisterSuccsessfully")
	public void RegisterUserCanLogin() 
	{
		homeobject.openLoginPage();
		loginobject=new LoginPage(drive);
		loginobject.UserLogin("makkklportil1557890@gmail.com", "123456789");
		Assert.assertTrue(drive.findElement(registobject.logoutlink).getText().contains("Log out"));
	}

}
