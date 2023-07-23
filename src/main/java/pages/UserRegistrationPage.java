package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserRegistrationPage extends PageBase {	
	public UserRegistrationPage(WebDriver drive) {
		super(drive);

	}
	By genderRadioBtn = By.id("gender-male");

	By fnTextBox =By.id ("FirstName") ;

	By lnTextBox = By.id ("LastName");

	By emailTextBox = By.id ("Email");

	By passTextBox = By.id("Password");

	By confirmpassTextBox = By.id("ConfirmPassword");

	By registerBtn = By.id("register-button");

	public By successMessage = By.xpath ( "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]"); 

	public By logoutlink = By.xpath ("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");

	By myaccountlink = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a");

	public void userRegistration(String firstname , String Lastname , String email , String password) 
	{
		clickButton(genderRadioBtn);
		setTextElementText(fnTextBox, firstname);
		setTextElementText(lnTextBox, Lastname);
		setTextElementText(emailTextBox, email);
		setTextElementText(passTextBox, password);
		setTextElementText(confirmpassTextBox, password);
		clickButton(registerBtn);
	}

	public void UserLogout() 
	{
		clickButton(logoutlink);
	}

	public void OpenMyAccountPage() 
	{
		clickButton(myaccountlink);
	}



}
