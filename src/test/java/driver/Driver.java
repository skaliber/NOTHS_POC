package driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Driver extends EventFiringWebDriver {

	public static WebDriver REAL_DRIVER;
	static String BROWSER = "chrome";
    
	private static final Thread CLOSE_THREAD = new Thread() {

		@Override
		public void run() {
		REAL_DRIVER.quit();

		}
	};

	static {
		 switch (BROWSER) {
		case "firefox":
			StartFirefox();
			break;
			
		case "chrome":
			StartChrome();
			break;
			
		case "headless":
			StartHtmlUnit();
			break;

		default:
			StartHtmlUnit();
			break;
		}
		 
	}

	public Driver() {
		super(REAL_DRIVER);
	}
	
	static void StartChrome(){
		 Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
		 REAL_DRIVER = new ChromeDriver();
		
	}
	
	static void StartFirefox(){
		
		 Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
		 REAL_DRIVER = new FirefoxDriver();
		
	}
	
	static void StartHtmlUnit(){
		
		 Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
		 REAL_DRIVER = new HtmlUnitDriver (BrowserVersion.FIREFOX_24){
				
				@Override
				protected WebClient modifyWebClient(WebClient client) {
					client.setAjaxController(new NicelyResynchronizingAjaxController());
					client.getOptions().setThrowExceptionOnScriptError(false);
					client.getOptions().setJavaScriptEnabled(true);
					return super.modifyWebClient(client);
				}
			};	
		
	}
	
	@Before
	public void Setup() {

		manage().deleteAllCookies();
		
		REAL_DRIVER.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		REAL_DRIVER.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		REAL_DRIVER.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	}

	@Override
	public void close() {

		if (Thread.currentThread() != CLOSE_THREAD) {

			throw new UnsupportedOperationException(

					"You shouldn't close this WebDriver. It's shared and will close when the JVM exits.");
		}
		super.close();

	}

	@After
	public void embedScreenshot(Scenario scenario) {

		try {
			byte[] screenshot = getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		} catch (WebDriverException somePlatformsDontSupportScreenshots) {
			System.err.println(somePlatformsDontSupportScreenshots.getMessage());

		}		
		REAL_DRIVER.quit();
        REAL_DRIVER = null;
	}
}

