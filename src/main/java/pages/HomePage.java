package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver drive) {
		super(drive);
		js=(JavascriptExecutor) drive ;
		action = new Actions(drive);
	}
	By registerlink = By.linkText("Register");

	public void openUserRegistrationPage() 
	{
		clickButton(registerlink);
	}

	By loginlink = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");

	public void openLoginPage () 
	{
		clickButton(loginlink);
	}

	By contactuslink = By.linkText("Contact us");

	public void OpenContactUsPage () 
	{
		scrollingPageToBottom();
		clickButton(contactuslink);
	}

	By currencyList = By.id("customerCurrency");

	public void changecurrency () 
	{
		select = new Select(drive.findElement(currencyList));
		select.selectByIndex(1);
	}

	By Computerhovermenu =By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a");
	
	By NoteboxMenu =By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a");
	

	public void selectNotebooksMenu () 
	{
		action.moveToElement(drive.findElement(Computerhovermenu))
		.moveToElement(drive.findElement(NoteboxMenu)).click().build().perform();
	}
}
