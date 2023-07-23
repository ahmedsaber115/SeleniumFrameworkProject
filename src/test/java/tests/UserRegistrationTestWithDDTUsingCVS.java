package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTUsingCVS extends TestBase {

	HomePage homeobject;
	UserRegistrationPage registobject ;
	LoginPage loginobject;

	CSVReader reader ;

	@Test 
	public void UserCanRegisterSuccsessfully() throws IOException, Exception
	{
		String csv_file =System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.csv";
		reader = new CSVReader(new FileReader(csv_file));

		String [] csvcell ;
		while ((csvcell= reader.readNext()) != null) 
		{
			String fname = csvcell[0];
			String lname = csvcell[1];
			String email = csvcell[2];
			String password = csvcell[3];

			homeobject=new HomePage(drive);
			homeobject.openUserRegistrationPage();
			registobject=new UserRegistrationPage(drive); 
			registobject.userRegistration(fname ,lname ,email, password);
			Assert.assertTrue(drive.findElement(registobject.successMessage).getText().contains("Your registration completed"));
			
			homeobject.openLoginPage();
			loginobject=new LoginPage(drive);
			loginobject.UserLogin(email, password);
			Assert.assertTrue(drive.findElement(registobject.logoutlink).getText().contains("Log out"));
			registobject.UserLogout();
		}


	}
}

