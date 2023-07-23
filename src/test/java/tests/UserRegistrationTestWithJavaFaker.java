package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithJavaFaker extends TestBase {
	
	HomePage homeobject;
	UserRegistrationPage registobject ;
	LoginPage loginobject;
	
	Faker fakedata = new Faker();
	String firstname = fakedata.name().firstName();
	String lastname = fakedata.name().lastName();
	String email = fakedata.internet().emailAddress();
	String password =fakedata.number().digits(8).toString();
	
	@Test(priority = 1 , alwaysRun = true)
	public void UserCanRegisterSuccsessfully() throws InterruptedException 
	{
	homeobject=new HomePage(drive);
	homeobject.openUserRegistrationPage();
	registobject=new UserRegistrationPage(drive); 
	registobject.userRegistration(firstname,lastname,email,password);
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
		loginobject.UserLogin(email, password);
		Assert.assertTrue(drive.findElement(registobject.logoutlink).getText().contains("Log out"));
	}

}
