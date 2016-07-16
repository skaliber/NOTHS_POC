package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.BaseClass;
import utils.Wait;

public class SeleniumActions extends BaseClass{

	public SeleniumActions(WebDriver driver) {
		super(driver);
		
	}
	
	public void type(Boolean clear,WebElement element,String text){
		
		if (clear) {
			
			element.clear();
			Wait.WaitAWhile(2);
			element.sendKeys(text);
			
		}else{
			
			element.sendKeys(text);
		}
		
	}
	


}
