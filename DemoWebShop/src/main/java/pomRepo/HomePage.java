package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
	@FindBy(linkText = "Register")
	private WebElement register;
	
	@FindBy(linkText = "Log in")
	private WebElement login;
	
	@FindBy(xpath = "//span[text()='Shopping cart']")
	private WebElement shoppingCart;
	
	@FindBy(xpath="//span[text()='Wishlist']")
	private WebElement wishList;
	
	@FindBy(partialLinkText = "Books")
	private WebElement books;
	
	@FindBy(partialLinkText = "Computers")
	private WebElement computers;
	
	@FindBy(partialLinkText = "Electronics")
	private WebElement electronics;
		
	@FindBy(partialLinkText = "Apparel & Shoes")
	private WebElement apparelAndShoes;
	
	@FindBy(partialLinkText = "Digital downloads")
	private WebElement digitalDownloads;
	@FindBy(partialLinkText = "Jewelry")
	private WebElement jewelary;
	
	@FindBy(partialLinkText = "Gift Cards")
	private WebElement giftCards;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getRegister() {
		return register;
	}
	public WebElement getLogin() {
		return login;
	}
	public WebElement getShoppingCart() {
		return shoppingCart;
	}
	public WebElement getWishList() {
		return wishList;
	}
	public WebElement getBooks() {
		return books;
	}
	public WebElement getComputers() {
		return computers;
	}
	public WebElement getElectronics() {
		return electronics;
	}
	public WebElement getApparelAndShoes() {
		return apparelAndShoes;
	}
	public WebElement getDigitalDownloads() {
		return digitalDownloads;
	}
	public WebElement getJewelary() {
		return jewelary;
	}
	public WebElement getGiftCards() {
		return giftCards;
	}
	
	
	
	
}
