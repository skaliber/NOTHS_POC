package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utils.Wait;

public class AddToBasketPage extends BaseClass{

	public AddToBasketPage(WebDriver driver){
		super(driver);
	
	}    
	
	@FindBy(how=How.CLASS_NAME, using="product_title")
	public static WebElement productTitle;
	
	@FindBy(how=How.NAME, using="line_item[options_attributes][1][product_option_value_id][currency_GBP]")
	public static WebElement option;
	
	@FindBy(how=How.CLASS_NAME, using="add_to_cart_button")
	public static WebElement addTobasketButton;

	public  void  AddItemToBasket(Boolean option){
		
		if(option){
			
			ChooseOption();
			ClickOnAddToBasket();
		}
		else {
			ClickOnAddToBasket();
		}	
	}
	
	public void ChooseOption(){
		
		option.sendKeys("A5");
		
	}
	
	public void ClickOnAddToBasket(){
		
		addTobasketButton.click();
		Wait.WaitAWhile(6);
		
	}
	
	

}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
