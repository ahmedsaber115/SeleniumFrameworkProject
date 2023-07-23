package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver drive) {
		super(drive);
	}
	public By currentproduct = By.cssSelector("strong.current-item");

	By emailfriendBTN = By.cssSelector("button.button-2.email-a-friend-button");


	public By pricelabel = By.cssSelector("span#price-value-4");

	public void OpenemailfriendPage () 
	{
		clickButton(emailfriendBTN);
	}
	
	By addreviewlink = By.linkText("Add your review");
	
	public void openReviewPage () 
	{
		clickButton(addreviewlink);
	}
	
	By addwishlistlink = By.id("add-to-wishlist-button-4");
	By wishlinkopen = By.xpath("//*[@id=\"bar-notification\"]/div/p/a");
	
	public void openWishlistPage () throws InterruptedException 
	{
		clickButton(addwishlistlink);
		Thread.sleep(3000);
		clickButton(wishlinkopen);
	}
	
	By addTocompareBTN = By.cssSelector("button.button-2.add-to-compare-list-button");
	public void addProductToCompare() 
	{
		clickButton(addTocompareBTN);
	}

	By addtocardBTN = By.id("add-to-cart-button-4");
	By shoppingcardlink = By.xpath("//*[@id=\"bar-notification\"]/div/p/a"
);
	
	public void addToCart () throws InterruptedException 
	{
		clickButton(addtocardBTN);
		Thread.sleep(2000);
	}
	public void OpenShoppingCartPage () 
	{
		clickButton(shoppingcardlink);
	}




}
