package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductReviewPage extends PageBase {

	public ProductReviewPage(WebDriver drive) {
		super(drive);	
	}
	By reviewTitleTextbox = By.id("AddProductReview_Title");
	
	By ReviewTXTtextBox = By.id("AddProductReview_ReviewText");
	
	By submitreviewBTN = By.cssSelector("button.button-1.write-product-review-button");
	
	By ratingradioBTn = By.id("addproductrating_2");
	
	public By succmsg = By.cssSelector("div.result");

	
	public void productReview (String reviewTitle , String ReviewText) 
	{
	 setTextElementText(reviewTitleTextbox, reviewTitle);
	 setTextElementText(ReviewTXTtextBox, ReviewText);
	 clickButton(ratingradioBTn);
	 clickButton(submitreviewBTN);
	}
	

}
