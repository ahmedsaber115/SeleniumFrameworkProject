package utilitiesHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	//method to take screenshot when test case fail
	public static void captureScreenshot (WebDriver drive, String screenshotname) 
	{
		Path dest =Paths.get("./screenshots", screenshotname +".png");
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot) drive).getScreenshotAs(OutputType.BYTES));
			out.close();
			
		} catch (IOException e) {
			System.out.println("Excpetion while taking screenshot" + e.getMessage());
		}
		
	}

}
