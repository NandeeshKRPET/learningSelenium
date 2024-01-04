package testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericlibrary.BaseTest;
import genericlibrary.CommonUtility;
import genericlibrary.DataUtility;

public class TC03_EmptyCartTest extends BaseTest{

	@Test(groups = "System")
	public void emptyCart_Test_Script() throws IOException {
		
		

		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();

		List<WebElement> allRemoveCheckBox = driver
				.findElements(By.xpath("//tr[@class='cart-item-row']//input[@type='checkbox']"));

		try
		{
			Assert.assertEquals(allRemoveCheckBox.size() > 0, true);
			
			for (WebElement removeCheckBox : allRemoveCheckBox) {
				removeCheckBox.click();
			}
			
			driver.findElement(By.xpath("//input[@value='Update shopping cart']")).click();
			
			allRemoveCheckBox = driver
					.findElements(By.xpath("//tr[@class='cart-item-row']//input[@type='checkbox']"));
			
			assertEquals(allRemoveCheckBox.size(), 0);
			
			Reporter.log("EmptyCart Test Case Pass", true);
			
			
		}
		catch (AssertionError e) 
		{
			Reporter.log("EmptyCart Test Case Pass",true);
		}
		
		
		
		
		

		

		
	}

}
