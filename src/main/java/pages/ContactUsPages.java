package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPages extends PageBase {

	public ContactUsPages(WebDriver drive) {
		super(drive);
	}

	By yournametextbox = By.id("FullName");
	
	By yourEmailTextbox = By.id("Email");

	By EnquiryTextbox = By.id("Enquiry");
	
	By submitBTN = By.cssSelector("button.button-1.contact-us-button");
	
	public By sucessMesssage = By.cssSelector("div.result");
	
	
	public void UserCanContactUs(String fullname , String email , String enquiry ) 
	{
		setTextElementText(yournametextbox, fullname);
		setTextElementText(yourEmailTextbox, email);
		setTextElementText(EnquiryTextbox, enquiry);
		clickButton(submitBTN);
	}

}
