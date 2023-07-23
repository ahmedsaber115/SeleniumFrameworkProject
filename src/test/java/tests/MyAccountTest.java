package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase {

	HomePage homeobject;
	UserRegistrationPage registobject ;
	LoginPage loginobject;
	MyAccountPage myaccountobject ;
	String newpassword="4479999";
	String oldpassword="55566688";
	String email="ahmsoorpp578232@gmail.com";


	@Test(priority = 1)
	public void UserCanRegisterSuccsessfully() throws InterruptedException 
	{
		homeobject=new HomePage(drive);
		homeobject.openUserRegistrationPage();
		registobject=new UserRegistrationPage(drive); 
		registobject.userRegistration("nn58kh", "ss47",email , oldpassword);
		Assert.assertTrue(drive.findElement(registobject.successMessage).getText().contains("Your registration completed"));
		Thread.sleep(2000);
	}
	@Test (priority = 2)
	public void RegisterUserCanLogin() throws InterruptedException 
	{
		homeobject.openLoginPage();
		loginobject=new LoginPage(drive);
		loginobject.UserLogin(email, oldpassword);
		Assert.assertTrue(drive.findElement(registobject.logoutlink).getText().contains("Log out"));
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void changepasswordTest() throws InterruptedException
	{
		registobject.OpenMyAccountPage();
		myaccountobject=new MyAccountPage(drive);
		myaccountobject.openChangepassPage();
		myaccountobject.changePasswordPage(oldpassword, newpassword);
	}
	@Test(priority = 4)
	public void RegisterUserCanLogout () throws InterruptedException
	{
		Thread.sleep(2000);
		registobject.UserLogout();
	}

	@Test (dependsOnMethods = "RegisterUserCanLogout")
	public void UserCanLoginAfterChangePass() 
	{
		homeobject.openLoginPage();
		loginobject=new LoginPage(drive);
		loginobject.UserLogin(email, newpassword);
		Assert.assertTrue(drive.findElement(registobject.logoutlink).getText().contains("Log out"));
	}


}
