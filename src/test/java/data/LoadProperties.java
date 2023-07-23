package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	
	//load data from file
	
	public static Properties 
	userdata = loadproperties(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\userdata.properties");
	
	private static Properties loadproperties (String path) 
	{
		Properties pro =new Properties();
		//stream for read file 
		try {
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pro;
		}
	}

