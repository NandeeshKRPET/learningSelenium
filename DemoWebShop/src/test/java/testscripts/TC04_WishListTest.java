package testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericlibrary.BaseTest;
import genericlibrary.DataUtility;

public class TC04_WishListTest extends BaseTest {

	@Test(groups = "System")
	public void wishList_Test_Script() throws IOException {

		driver.findElement(By.partialLinkText("Books")).click();

		WebElement product = driver.findElement(By.linkText("Fiction EX"));

		product.click();

		driver.findElement(By.xpath("//input[@value='Add to wishlist']")).click();

		driver.findElement(By.xpath("//span[text()='Wishlist']")).click();

		WebElement wishListProduct = driver.findElement(By.xpath("//a[text()='Fiction EX']"));

		assertEquals(wishListProduct.isDisplayed(), true);
		Reporter.log("Wish List Test Case Pass..",true);
		
		

		List<WebElement> allRemoveCheckBox = driver.findElements(By.xpath("//td[@class='remove-from-cart']/input"));

		for (WebElement checkBox : allRemoveCheckBox) {
			checkBox.click();
		}

		driver.findElement(By.xpath("//input[@value='Update wishlist']")).click();

	}
}
