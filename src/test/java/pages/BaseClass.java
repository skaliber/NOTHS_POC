package pages;

import helper.SeleniumActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utils.Wait;

public class BaseClass
{
	protected static WebDriver driver;
	public static boolean bResult;

	public  BaseClass(WebDriver driver){
		
		BaseClass.driver = driver;
		BaseClass.bResult = true;
		PageFactory.initElements(driver, this);
		
	}
	
	public Navigate Navigate(){
		
		return new Navigate(driver);
		
	}

    public BasketPage Basket(){
    	
    	return new BasketPage(driver);
    }
    
  public ProductPage Addtobasket(){
    	
    	return new ProductPage(driver);
    }
  
  public SeleniumActions action(){
	  
	  return new SeleniumActions(driver);
  }

}
