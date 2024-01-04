package pomRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DigitalDownloadsPage
{
	
	@FindBy(id="products-orderby")
	private WebElement sortByDropdown;
	
	@FindBy(id="products-pagesize")
	private WebElement displayDropdown;
	
	@FindBy(id="products-viewmode")
	private WebElement viewAsDropdown;
	
	@FindBy(xpath="//input[@value='Add to cart']")
	private List<WebElement> allProductList;
	
	public DigitalDownloadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSortByDropdown() {
		return sortByDropdown;
	}

	public WebElement getDisplayDropdown() {
		return displayDropdown;
	}

	public WebElement getViewAsDropdown() {
		return viewAsDropdown;
	}

	public List<WebElement> getAllProductList() {
		return allProductList;
	}
	
	
	
	
	

}
