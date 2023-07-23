package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompareProductPage extends PageBase {

	public CompareProductPage(WebDriver drive) {
		super(drive);
	}
	By clearlistBTN = By.cssSelector("a.clear-list");

	public By nodatamssg = By.cssSelector("div.no-data");


	public void Clearwishlist() 
	{
		clickButton(clearlistBTN);
	}

	public void PtoductCompare () 
	{

		WebElement comparetable = drive.findElement(By.cssSelector("table.compare-products-table"));

		List<WebElement> allrows = comparetable.findElements(By.tagName("tr"));
		//get all rows
		System.out.println(allrows.size());

		//get data from each rows
		for(WebElement row : allrows) 
		{
			System.out.print(row.getText() + "\t");
			List<WebElement> allcol = row.findElements(By.tagName("td"));
			for(WebElement col : allcol) 
			{
				System.out.print(col.getText() + "\t");
			}
		}
	}


}
