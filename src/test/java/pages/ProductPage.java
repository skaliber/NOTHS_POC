package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BaseClass {

	public ProductPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(how = How.CLASS_NAME, using = "product_title")
	public static WebElement productTitle;

	@FindBy(how = How.NAME, using = "line_item[options_attributes][1][product_option_value_id][currency_GBP]")
	public static WebElement option;

	@FindBy(how = How.NAME, using = "button_add_to_cart")
	public static WebElement addTobasketButton;

	@FindBy(how = How.CLASS_NAME, using = "quantity_input")
	public static WebElement qty;

	@FindBy(how = How.CLASS_NAME, using = "inline-errors")
	public static WebElement InlineError;

	public ProductPage AddItemToBasket(Boolean qtydefault, Integer value) {

		ChangeQty(value);
		ChooseOption();
		ClickOnAddToBasket();

		return this;
	}

	public ProductPage AddItemToBasket() {

		ChooseOption();
		ClickOnAddToBasket();

		return this;
	}

	public ProductPage AddItemToBasket(String Error) {

		ClickOnAddToBasket();
		CheckErrorMessage(Error);

		return this;
	}

	public void ChooseOption() {

		action().type(false, option, "A5");

	}

	public void ClickOnAddToBasket() {

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(addTobasketButton));

		addTobasketButton.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public void ChangeQty(Integer value) {

		action().type(true, qty, value.toString());

	}

	public void CheckErrorMessage(String Value) {

		String errortext = InlineError.getText();
		Assert.assertTrue(errortext.contains(Value));

	}
}
