package stepDefinations;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import pages.ProductDetailsPage;
import pages.ProductInformationPage;
import pages.SearchPage;
import pages.ShoppingCardPage;
import tests.TestBase;

public class E2ETests extends TestBase {
	SearchPage searchobject ;
	ProductDetailsPage detailedObject;
	CheckoutPage checkobject;
	ProductInformationPage informationobject ;
	ShoppingCardPage shoppingcartobject;

	@Given("user is in Home Page")
	public void user_is_in_home_page() {
		Assert.assertTrue(drive.getCurrentUrl().contains("nopcommerce.com"));
	}

	@When("he search for {string}")
	public void he_search_for(String productName) throws InterruptedException {
		searchobject=new SearchPage(drive);
		searchobject.productsearchUsingAutoSugg(productName);
		detailedObject=new ProductDetailsPage(drive);
		Assert.assertTrue(drive.findElement(detailedObject.currentproduct).getText().equalsIgnoreCase(productName));

	}

	@When("choose to buy Tow items")
	public void choose_to_buy_tow_items() throws InterruptedException {
		detailedObject=new ProductDetailsPage(drive);
		detailedObject.addToCart();
		detailedObject.OpenShoppingCartPage();

	}

	@When("moves to checkout cart and enter personal details on checkout page and place the order")
	public void moves_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_the_order() throws InterruptedException {
		
		shoppingcartobject=new ShoppingCardPage(drive);
		shoppingcartobject.openCheckoutPage();
		checkobject=new CheckoutPage(drive);
		checkobject.CheckoutAsGuest("Egypt", "Cairo", "Test adress", "123458",
				"12597745" , "ahmed" , "saber" , "ahme204406058963@gmail.com");
	}

	@Then("he can view the order and download the invoice")
	public void he_can_view_the_order_and_download_the_invoice() throws InterruptedException {
		checkobject=new CheckoutPage(drive);
		checkobject.OpenInformationPage();
		informationobject =new ProductInformationPage(drive);
		informationobject.printaoarderDetails();
		informationobject.DownloadPDFInvoice();
	}

}
