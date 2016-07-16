package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class BasketPage extends BaseClass{

	public BasketPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(how=How.CLASS_NAME, using="fancybox-inner")
	public static List<WebElement> basketModal;
	
	@FindBy(how=How.CSS, using="#basket .total")
	public static WebElement basketItems;
	
	public static String basket = "1 item";
	
	public static String productName ="Typography Print";
	
	public BasketPage CheckItemIsAddedIntoBasket(){
		
		Assert.assertTrue("basket modal should be displayed", IsBaketModalDisplayed());
		
		String total = basketItems.getText();
		
		Assert.assertTrue("Maybe the item wasn't added into the basket", total.contains(basket));
		
		return this;
	}
	
	private Boolean IsBaketModalDisplayed(){
		
		if (basketModal.size() != 0)
		{
			return true;
		}
		else 
		{
			
			return false;
		}
	}

}
