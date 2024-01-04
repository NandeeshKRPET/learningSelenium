package genericlibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import pomRepo.HomePage;
import pomRepo.LoginPage;

public class BaseTest
{
	public DataUtility data_Utility;
	public WebDriver driver;
	public static WebDriver listnerDriver;
	
	//
	//doing some changes
	//
	
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(@Optional("chrome") String browserName) throws IOException
	{
		data_Utility = new DataUtility();
		
		if(browserName.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browserName.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Enter Valid Browser Name.");
		}
		
		listnerDriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(data_Utility.getDataFromProperties("url"));
	}
	
	@BeforeMethod(alwaysRun = true)
	public void login() throws IOException
	{
//		driver.findElement(By.linkText("Log in")).click();
//		driver.findElement(By.id("Email")).sendKeys(data_Utility.getDataFromProperties("email"));
//		driver.findElement(By.id("Password")).sendKeys(data_Utility.getDataFromProperties("password"));
//		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		
		HomePage hp = new HomePage(driver);
		hp.getLogin().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.getEmailTextField().sendKeys(data_Utility.getDataFromProperties("email"));
		lp.getPasswordTextField().sendKeys(data_Utility.getDataFromProperties("password"));
		lp.getLoginButton().click();
	}
	
	@AfterMethod(alwaysRun = true)
	public void logout()
	{
		driver.findElement(By.linkText("Log out")).click();
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser()
	{
		driver.close();
	}
	
	
}
