package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPages;
import pages.HomePage;

public class CnotactUsTest extends TestBase {
	HomePage homeobject ;
	ContactUsPages contactusObject ;
	String  fullname = "ahmedsaber" ;
	String   email = "ahme9499l6@gmail.com" ;
	String   enquiry = "we can automate anything" ;
	
	@Test
	public void contactusTest () 
	{
		homeobject = new HomePage(drive);
		contactusObject= new ContactUsPages(drive);
		 homeobject.OpenContactUsPage();
		 contactusObject.UserCanContactUs(fullname, email, enquiry);
		 Assert.assertTrue(drive.findElement(contactusObject.sucessMesssage).getText().contains("Your enquiry has been successfully sent to the store owner"));
	}

}
