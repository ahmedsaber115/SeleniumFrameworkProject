package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver drive) {
		super(drive);
	}
	By changepasslink = By.xpath("/html/body/div[6]/div[3]/div/div[1]/div/div[2]/ul/li[7]/a");
	
	By OldPasswordTextBox = By.id("OldPassword");
	
	By NewPasswordTextBox = By.id("NewPassword");

	By ConfirmPasswordTextBox = By.id("ConfirmNewPassword");

	By changepasswordbtn = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/form/div[2]/button");

	By closeBtn = By.xpath("//*[@id=\"bar-notification\"]/div/span");
	

	public void openChangepassPage() 
	{
		clickButton(changepasslink);
	}
	public void changePasswordPage(String oldpassword , String newpassword ) throws InterruptedException 
	{
		setTextElementText(OldPasswordTextBox, oldpassword);
		setTextElementText(NewPasswordTextBox, newpassword);
		setTextElementText(ConfirmPasswordTextBox, newpassword);
		clickButton(changepasswordbtn);
		clickButton(closeBtn);
		Thread.sleep(5000);
	}

}
