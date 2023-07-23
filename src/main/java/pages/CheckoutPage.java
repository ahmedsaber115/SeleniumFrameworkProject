package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase {

	public CheckoutPage(WebDriver drive) {
		super(drive);

	}
	By billigselectcountrylist = By.id("BillingNewAddress_CountryId");

	By billigcityText = By.id("BillingNewAddress_City");

	By billigadressText = By.id("BillingNewAddress_Address1");

	By billigzipcodeText = By.id("BillingNewAddress_ZipPostalCode");

	By billigphonenumbertext = By.id("BillingNewAddress_PhoneNumber");

	By billigcontinueBtn = By.cssSelector("button.button-1.new-address-next-step-button");

	By shippingcontinueBtn = By.cssSelector("button.button-1.shipping-method-next-step-button");

	By paymethodcontinueBtn = By.cssSelector("button.button-1.payment-method-next-step-button");

	By paymentcontinueBtn = By.cssSelector("button.button-1.payment-info-next-step-button");

	By confirmorderBtn = By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button");

	public By thankuouMSG = By.cssSelector("h1");

	public By succMSG = By.cssSelector("strong");

	By orderdetailsBTN = By.linkText("Click here for order details.");

	By checkguestBTN = By.cssSelector("button.button-1.checkout-as-guest-button");

	By emailText = By.id("BillingNewAddress_Email");

	By firstnameText = By.id("BillingNewAddress_FirstName");

	By lastnameText = By.id("BillingNewAddress_LastName");


	public void RegisterUserCanCheckoutProduct (String countryname, String cityname , String adressname ,String zipcode, String pgonenumber ) throws InterruptedException 
	{
		select=new Select(drive.findElement(billigselectcountrylist));
		select.selectByVisibleText(countryname);
		setTextElementText(billigcityText, cityname);
		setTextElementText(billigadressText, adressname);
		setTextElementText(billigzipcodeText, zipcode);
		setTextElementText(billigphonenumbertext, pgonenumber);
		clickButton(billigcontinueBtn);
		Thread.sleep(1000);
		clickButton(shippingcontinueBtn);
		Thread.sleep(1000);
		clickButton(paymethodcontinueBtn);
		Thread.sleep(2000);
		clickButton(paymentcontinueBtn);
		Thread.sleep(2000);
		clickButton(confirmorderBtn);
		Thread.sleep(2000);
	}

	public void OpenInformationPage () 
	{
		clickButton(orderdetailsBTN);
	}

	//checkout AS a Guest 

	public void CheckoutAsGuest(String countryname, String cityname 
			, String adressname ,String zipcode, String pgonenumber
			, String firstname , String lasttname ,String email) throws InterruptedException 
	{
		clickButton(checkguestBTN);
		setTextElementText(firstnameText, firstname);
		setTextElementText(lastnameText, lasttname);
		setTextElementText(emailText, email);
		select=new Select(drive.findElement(billigselectcountrylist));
		select.selectByVisibleText(countryname);
		setTextElementText(billigcityText, cityname);
		setTextElementText(billigadressText, adressname);
		setTextElementText(billigzipcodeText, zipcode);
		setTextElementText(billigphonenumbertext, pgonenumber);
		clickButton(billigcontinueBtn);
		Thread.sleep(1000);
		clickButton(shippingcontinueBtn);
		Thread.sleep(1000);
		clickButton(paymethodcontinueBtn);
		Thread.sleep(2000);
		clickButton(paymentcontinueBtn);
		Thread.sleep(2000);
		clickButton(confirmorderBtn);
		Thread.sleep(2000);
	}

}
