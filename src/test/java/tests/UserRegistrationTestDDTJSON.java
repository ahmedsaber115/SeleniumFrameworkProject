package tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestDDTJSON extends TestBase 
{
	
	HomePage homeobject;
	UserRegistrationPage registobject ;
	LoginPage loginobject;

	@Test(priority = 1 )
	public void UserCanRegisterSuccsessfully() throws InterruptedException, IOException, IOException, ParseException 
	{
		JsonDataReader jsonreader =new JsonDataReader();
		jsonreader.jsonReader(System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.json" );
		
		
	homeobject=new HomePage(drive);
	homeobject.openUserRegistrationPage();
	registobject=new UserRegistrationPage(drive); 
	registobject.userRegistration(jsonreader.firstname,jsonreader.lastname,jsonreader.email,jsonreader.password);
	Assert.assertTrue(drive.findElement(registobject.successMessage).getText().contains("Your registration completed"));
	
	homeobject.openLoginPage();
	loginobject=new LoginPage(drive);
	loginobject.UserLogin(jsonreader.email, jsonreader.password);
	Assert.assertTrue(drive.findElement(registobject.logoutlink).getText().contains("Log out"));
	registobject.UserLogout();
	}
}

