package pageelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AbstractMethods;

public class Electronicspage extends AbstractMethods {

	public Electronicspage(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@data-csa-c-id='bxqrou-8fu7j2-vv6vn-wg2rbm']")
	WebElement electronics;

	@FindBy(xpath = "//span[text() = 'Mobiles & Accessories']")
	WebElement Mobiles;
	
	@FindBy(xpath = "(//span[text() = 'Shop now'])[2]")
	WebElement Shopnow;
	
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement addcart;
	
	public void searchelectronics() {
		implicitlywaitmethod();
		try {
			electronics.click();
			Mobiles.click();
			Shopnow.click();
			addcart.click();
		}
		catch(Exception e) {
			System.out.println("search electronics");
		}
	}
}
