package pages;


import org.openqa.selenium.WebDriver;

import utils.Log;
import utils.Wait;

public class Navigate extends BaseClass {
	
	Wait wait;
	public Navigate(WebDriver driver) {
		super(driver);
		this.wait = new Wait(driver);
	}
	
	public void Go(String URL){
		
		driver.navigate().to(URL);
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Wait.WaitAWhile(1);
		
		while (wait.waitForJSandJQueryToLoad() == false) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		Log.info("navigate to " + " " + URL);
	}
	

}
