package testscripts;

import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericlibrary.CommonUtility;
import genericlibrary.DataUtility;

public class TC01_RegisterTest {
	
	@Test(groups = "smoke")
	public void registration_Test_Script() throws EncryptedDocumentException, IOException {
		DataUtility data_Utility = new DataUtility();
		CommonUtility common_utility = new CommonUtility();
		//UserName = Testengg111@gmial.com
		//password = Engg@123
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(data_Utility.getDataFromProperties("url"));
		
		driver.findElement(By.partialLinkText("Regis")).click();
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.name("FirstName")).sendKeys(data_Utility.getDataFromExcel("Registration-Data", 1, 1));
		driver.findElement(By.name("LastName")).sendKeys(data_Utility.getDataFromExcel("Registration-Data", 1, 2));
		driver.findElement(By.name("Email")).sendKeys(common_utility.getRandomNumber()+data_Utility.getDataFromExcel("Registration-Data", 1, 3));
		driver.findElement(By.name("Password")).sendKeys(data_Utility.getDataFromExcel("Registration-Data", 1, 4));
		driver.findElement(By.name("ConfirmPassword")).sendKeys(data_Utility.getDataFromExcel("Registration-Data", 1, 5));
		driver.findElement(By.name("register-button")).click();
		
		String expText=driver.findElement(By.xpath("//div[@class='result']")).getText();
		
		Assert.assertEquals(expText, data_Utility.getDataFromExcel("Registration-Data", 1, 6));
		Reporter.log("Register Test Case Pass",true);
		
		driver.findElement(By.linkText("Log out")).click();
		
		driver.close();
	}
}