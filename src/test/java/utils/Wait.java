package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BaseClass;

public class Wait extends BaseClass {

	public Wait(WebDriver driver) {
		super(driver);
		
	}

	public boolean waitForJSandJQueryToLoad() {

	    WebDriverWait wait = new WebDriverWait(driver, 30);

	    // wait for jQuery to load
	    ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
	      public Boolean apply(WebDriver driver) {
	        try {
	          return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
	        }
	        catch (Exception e) {
	          // no jQuery present
	          return true;
	        }
	      }
	    };

	    // wait for Javascript to load
	    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
	      public Boolean apply(WebDriver driver) {
	        return ((JavascriptExecutor)Wait.driver).executeScript("return document.readyState")
	        .toString().equals("complete");
	      }
	    };

	  return wait.until(jQueryLoad) && wait.until(jsLoad);
	}

	public static void WaitAWhile(int seconds){
		
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}

	
}
