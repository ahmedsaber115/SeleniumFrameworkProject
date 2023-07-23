 package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	protected static WebDriver drive;
	public JavascriptExecutor js;
	public Select select ;
	public Actions action;
	
	// Create Constructor
	public PageBase(WebDriver drive) 
	{
		PageBase.drive =drive;
	}
	
	protected static void  clickButton (By button) 
	{
		drive.findElement(button).click();
		
		
	}
	protected static void setTextElementText (By textElement , String value ) 
	{
		drive.findElement(textElement).sendKeys(value);
	}
	public void scrollingPageToBottom () 
	{
		js.executeScript("scrollBy(0,2500)");
	}
	public void ClearTxt (By element) 
	{
		drive.findElement(element).clear();
	}

	
	
}
