package genericlibrary;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CommonUtility {
	
	public void takeScreenShot(WebDriver driver,String name)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg = new File ("./Screenshots/"+name+".png");
		
		try {
			FileHandler.copy(src, trg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getRandomNumber()
	{
		Random r = new Random();
		return r.nextInt(1000);
	}
	

}
