package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndPropertiesFile extends TestBase {
	
	HomePage homeobject;
	UserRegistrationPage registobject ;
	LoginPage loginobject;
	String fname = LoadProperties.userdata.getProperty("firstname");
	String lname = LoadProperties.userdata.getProperty("lastname");
	String email = LoadProperties.userdata.getProperty("email");
	String password = LoadProperties.userdata.getProperty("password");
	
	
	@Test(priority = 1 , alwaysRun = true)
	public void UserCanRegisterSuccsessfully() throws InterruptedException 
	{
	homeobject=new HomePage(drive);
	homeobject.openUserRegistrationPage();
	registobject=new UserRegistrationPage(drive); 
	registobject.userRegistration(fname, lname , email , password);
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
		loginobject.UserLogin(email,password);
		Assert.assertTrue(drive.findElement(registobject.logoutlink).getText().contains("Log out"));
	}

}
