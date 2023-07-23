package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndExcel extends TestBase {
	
	HomePage homeobject;
	UserRegistrationPage registobject ;
	LoginPage loginobject;
	
	@DataProvider (name = "ExelData")
	public Object [][] userregisterdata () throws IOException{
	ExcelReader er =  new ExcelReader();
	return er.getExelData();
	}
	
	@Test(priority = 1 , dataProvider = "ExelData")
	public void UserCanRegisterSuccsessfully(String fname , String lname , String email , String password) throws InterruptedException 
	{
	homeobject=new HomePage(drive);
	homeobject.openUserRegistrationPage();
	registobject=new UserRegistrationPage(drive); 
	registobject.userRegistration(fname, lname, email , password );
	Assert.assertTrue(drive.findElement(registobject.successMessage).getText().contains("Your registration completed"));	
	
	homeobject.openLoginPage();
	loginobject=new LoginPage(drive);
	loginobject.UserLogin(email, password);
	Assert.assertTrue(drive.findElement(registobject.logoutlink).getText().contains("Log out"));

	registobject.UserLogout();
	
	
	}
}
