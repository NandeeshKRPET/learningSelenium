package testscripts;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericlibrary.BaseTest;
import genericlibrary.CommonUtility;
import genericlibrary.DataUtility;

@Listeners(genericlibrary.ListnersImplementation.class)
public class TC02_AddToCartTest extends BaseTest{

	@Test(groups = "System")
	public void addToCart_Test_Script() throws InterruptedException, EncryptedDocumentException, IOException {
		
		CommonUtility common_utility = new CommonUtility();
		
		
		//Step 3 : To navigate to Digital downloads
		driver.findElement(By.partialLinkText("Digital downloads")).click();
		
		Assert.assertEquals(driver.getTitle(), data_Utility.getDataFromExcel("Titles", 3, 1));
		Reporter.log ("Digital downloads page is displayed",true);
		
		
		
		//Step 4: Located all AddToCart buttons
		List<WebElement> allProducts=driver.findElements(By.xpath("//input[@value='Add to cart']"));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		//Step 5: To Add all the products to the cart
		for(WebElement product : allProducts )
		{
			product.click();	
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//a[text()='shopping cart']"))));
			Thread.sleep(1000);
		}
		
		//Step 6: To navigate to shopping cart
		driver.findElement(By.xpath("//span[text()='Shopping']")).click();
		
		Assert.assertEquals(driver.getTitle(), data_Utility.getDataFromExcel("Titles", 4, 1));
		Reporter.log("Shopping Cart page displayed",true);
		
		List<WebElement> cartProducts=driver.findElements(By.xpath("//tr[@class='cart-item-row']"));
		
		//Step 7: Validate the number of products in shopping cart
		
		Assert.assertEquals(allProducts.size(), cartProducts.size());
		Reporter.log("AddToCart Test Case Pass");
		common_utility.takeScreenShot(driver, "AddToCart");
		
	}
}
