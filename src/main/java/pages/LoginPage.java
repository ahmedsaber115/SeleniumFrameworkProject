package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver drive) {
		super(drive);
	}
	By emailTextbox = By.id("Email");

	By passwordTextBox = By.id("Password");
	
	By loginBtn = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button");
	
	public void UserLogin(String email , String password) 
	{
		setTextElementText(emailTextbox, email);
		setTextElementText(passwordTextBox, password);
		clickButton(loginBtn);
	}






}
