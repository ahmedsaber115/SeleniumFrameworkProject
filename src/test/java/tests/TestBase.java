package tests;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilitiesHelper.Helper;

public class TestBase  extends AbstractTestNGCucumberTests {
	public static WebDriver drive ;
	public static String downloadpath =System.getProperty("user.dir")+"\\downloads\\";
	public static ChromeOptions chromeoption() 
	{
		ChromeOptions option = new ChromeOptions();
		HashMap<String, Object> chromeprefs=new HashMap<String,Object>();
		chromeprefs.put("profile.default.content_settings.popups", 0);
		chromeprefs.put("download.default_directory", downloadpath);
		option.setExperimentalOption("prefs", chromeprefs);
		option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		return option;

	}

	@BeforeClass
	@org.testng.annotations.Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browsername)
	{
		if (browsername.equalsIgnoreCase("chrome"))
		{
			drive = new ChromeDriver(chromeoption());
		}
		else if (browsername.equalsIgnoreCase("firefox")) 
		{
			drive = new FirefoxDriver();
		}
		else if (browsername.equalsIgnoreCase("chromeheadless")) 
		{
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--headless");
			option.addArguments("--window-size=1920,1080");
			drive = new ChromeDriver(option);
		}

		drive.manage().window().maximize();
		drive.navigate().to("https://demo.nopcommerce.com/");

	}

	@AfterClass
	public void stopDriver() 
	{
		drive.quit();
	}

	@AfterMethod
	public void screenshotOnFailure (ITestResult result) 
	{
		if (result.getStatus()== ITestResult.FAILURE) {
			System.out.println("Failed!");
			System.out.println("Taking Screenshot!");
			Helper.captureScreenshot(drive, result.getName());
		}
	}

}
