package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utils.Wait;

public class BasketPage extends BaseClass {

	public BasketPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(how = How.CLASS_NAME, using = "fancybox-inner")
	public static List<WebElement> basketModal;

	@FindBy(how = How.CSS, using = "#basket .total")
	public static WebElement basketItems;

	public static String basket = "item";

	public static String productName = "Typography Print";

	public BasketPage CheckItemIsAddedIntoBasket(Boolean defaultqty, Integer qty) {

		for (int i = 0; i < 5; i++) {

			if (IsBasketModalDisplayed() == false) {

				Wait.WaitAWhile(1);
			} else {

				Assert.assertTrue("basket modal should be displayed",
						IsBasketModalDisplayed());
			}
		}

		Assert.assertTrue("basket modal should be displayed",
				IsBasketModalDisplayed());

		String total = basketItems.getText();

		if (defaultqty) {

			Assert.assertTrue("Maybe the item wasn't added into the basket",
					total.contains(qty + " " + basket));
		} else {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			Assert.assertTrue("Maybe the items wasn't added into the basket",
					total.contains(qty + " " + basket + "s"));
		}

		return this;
	}

	private Boolean IsBasketModalDisplayed() {

		if (basketModal.size() != 0) {
			return true;
		} else {

			return false;
		}
	}

}
