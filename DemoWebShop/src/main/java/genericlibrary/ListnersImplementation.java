package genericlibrary;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnersImplementation implements ITestListener
{
	@Override
	public void onTestFailure(ITestResult result) 
	{
		TakesScreenshot ts = (TakesScreenshot)BaseTest.listnerDriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trgt = new File("./Screenshots/"+result.getName()+".png");
		
		try 
		{
			FileHandler.copy(src, trgt);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
