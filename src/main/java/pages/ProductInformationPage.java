package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductInformationPage extends PageBase {

	public ProductInformationPage(WebDriver drive) {
		super(drive);
	}
	By printBTN =By.cssSelector("a.button-2.print-order-button");

	By pdfinvoiceBTN =By.cssSelector("a.button-2.pdf-invoice-button");

	public void printaoarderDetails ()
	{
		clickButton(printBTN);
	}

	public void DownloadPDFInvoice () throws InterruptedException 
	{
		clickButton(pdfinvoiceBTN);
		Thread.sleep(2000);
	}


}
