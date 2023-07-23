package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailFriendPage extends PageBase {

	public EmailFriendPage(WebDriver drive) {
		super(drive);
	}
	By friendemailtectbox = By.id("FriendEmail");

	By personalmessagetectbox = By.id("PersonalMessage");

	By sendmailBTN = By.cssSelector("button.button-1.send-email-a-friend-button");

	public 	By successmsg = By.cssSelector("div.result");


	public void emailfriend(String freindemail , String personalmessage) 
	{
		setTextElementText(friendemailtectbox, freindemail);
		setTextElementText(personalmessagetectbox, personalmessage);
		clickButton(sendmailBTN);
	}


}
