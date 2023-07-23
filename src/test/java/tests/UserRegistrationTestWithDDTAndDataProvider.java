package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndDataProvider extends TestBase {
	
	HomePage homeobject;
	UserRegistrationPage registobject ;
	LoginPage loginobject;
	@DataProvider (name="testdata")
	public static Object [] [] data ()
	{
		return new Object [] []
				{ 
				{"ahmed" , "saber" , "ahmed20loo50@gmail.com" , "123456789"} ,
				{"mohammed" , "alaa" , "moham00do50000@gmail.com" , "123456788"} 
				};
	}
	
	@Test( dataProvider = "testdata")
	public void UserCanRegisterSuccsessfully(String fname , String lname
			, String email , String password) throws InterruptedException 
	{
	homeobject=new HomePage(drive);
	homeobject.openUserRegistrationPage();
	registobject=new UserRegistrationPage(drive); 
	registobject.userRegistration(fname, lname,email , password);
	Assert.assertTrue(drive.findElement(registobject.successMessage).getText().contains("Your registration completed"));
	
	homeobject.openLoginPage();
	loginobject=new LoginPage(drive);
	loginobject.UserLogin(email, password);
	Assert.assertTrue(drive.findElement(registobject.logoutlink).getText().contains("Log out"));
	registobject.UserLogout();
	}

}
