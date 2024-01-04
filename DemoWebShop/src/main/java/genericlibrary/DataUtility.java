package genericlibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtility {
	
	
	public String getDataFromProperties(String key) throws IOException
	{
		File f = new File("D:\\Nandeesh\\learningSelenium\\workspace\\DemoWebShop\\src\\test\\resources\\testData\\testData.properties");
		FileInputStream fis = new FileInputStream(f);
		Properties pob = new Properties();
		pob.load(fis);
		return pob.getProperty(key);
	}
	
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".src/test/resources/testData/Book1.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		return book.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
	}

}
