package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy(id="Email")
	private WebElement emailTextField;
	
	@FindBy(id="Password")
	private WebElement passwordTextField;
	
	@FindBy(id="RememberMe")
	private WebElement remembermeCheckBox;
	
	@FindBy(linkText = "Forgot password?")
	private WebElement forGotPasswordLink;
	
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement LoginButton;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	public WebElement getEmailTextField() {
		return emailTextField;
	}
	public WebElement getPasswordTextField() {
		return passwordTextField;
	}
	public WebElement getRemembermeCheckBox() {
		return remembermeCheckBox;
	}
	public WebElement getForGotPasswordLink() {
		return forGotPasswordLink;
	}
	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	

}
