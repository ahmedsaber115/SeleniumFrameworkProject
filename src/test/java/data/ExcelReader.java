package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	static FileInputStream fis = null ;
	public FileInputStream getFileinputStream ()
	{
		String filepath = System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserRgisterData.xlsx";
		File srcfile = new File(filepath);
		try {
			fis = new FileInputStream(srcfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return fis ;
	}
	
	public Object [][] getExelData() throws IOException
	{
		fis = getFileinputStream();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int TotalNumOfRows = (sheet.getLastRowNum()+1);
		int TotalNumOfCol =4;
		
		String [] [] arrayExcelSheet = new String [TotalNumOfRows][TotalNumOfCol];
		
		for (int i = 0; i < TotalNumOfRows; i++) 
		{
			for (int j = 0; j < TotalNumOfCol; j++)
			{
				XSSFRow row = sheet.getRow(i);
				arrayExcelSheet [i] [j] = row.getCell(j).toString();
			}
		}
		wb.close();
		return arrayExcelSheet;
	}
	

}
