package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.thoughtworks.selenium.webdriven.commands.Click;

import utils.Wait;

public class ProductPage extends BaseClass{

	public ProductPage(WebDriver driver){
		super(driver);
	
	}    
	
	@FindBy(how=How.CLASS_NAME, using="product_title")
	public static WebElement productTitle;
	
	@FindBy(how=How.NAME, using="line_item[options_attributes][1][product_option_value_id][currency_GBP]")
	public static WebElement option;
	
	@FindBy(how=How.CLASS_NAME, using="add_to_cart_button")
	public static WebElement addTobasketButton;
	
	@FindBy(how=How.CLASS_NAME, using="quantity_input")
	public static WebElement qty;
	

	public  void  AddItemToBasket(Boolean qtydefault,Integer value){
		
		if(qtydefault)
		{
			
			ChooseOption();
			
			ClickOnAddToBasket();
			
			
		}else{
			ChangeQty(value);
			ChooseOption();
			ClickOnAddToBasket();
			
		}
	}
	
	
	public void ChooseOption(){
		
		action().type(false, option, "A5");
		
	}
	
	public void ClickOnAddToBasket(){
		
		addTobasketButton.click();
		
	}
	
	public void ChangeQty(Integer value){
		
		action().type(true, qty, value.toString());
		
	}

}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
