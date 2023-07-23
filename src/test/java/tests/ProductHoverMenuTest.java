package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase{

	HomePage homeobject ;
	
	@Test
	public void usercanSelectSubProductfromHovermenu () 
	{
		homeobject=new HomePage(drive);
		homeobject.selectNotebooksMenu();
		Assert.assertTrue(drive.getCurrentUrl().contains("notebooks"));
	}
	
}
 