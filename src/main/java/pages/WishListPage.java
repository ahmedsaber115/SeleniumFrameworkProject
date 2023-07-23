package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListPage extends PageBase{

	public WishListPage(WebDriver drive) {
		super(drive);
	}
	By removeBTN = By.cssSelector("button.remove-btn");

	public By checkwishlistafterremove = By.cssSelector("div.no-data");

	public void RemoveWishlistproduct() 
	{
		clickButton(removeBTN);
	}


}
