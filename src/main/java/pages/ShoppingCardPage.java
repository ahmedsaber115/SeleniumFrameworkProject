package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCardPage extends PageBase {

	public ShoppingCardPage(WebDriver drive) {
		super(drive);
	}
	By quantitytxt = By.id("itemquantity11225");

	By updateshoppingcardBTN = By.id("updatecart");

	public By totalpricetxt = By.cssSelector("span.product-subtotal");

	By removeBTN = By.cssSelector("button.remove-btn");

	public By removemesg = By.cssSelector("div.no-data");
	
	By checkoutBTN = By.id("checkout");
	
	By termagreeBTN = By.id("termsofservice");

	public void shoppingcartquantityAndUpdate (String Quantity) 
	{
		clickButton(updateshoppingcardBTN);
	}

	public void shoppingcartRemove () 
	{
		clickButton(removeBTN);
	}
	public void openCheckoutPage () 
	{
		clickButton(termagreeBTN);
		clickButton(checkoutBTN);
	}

}
