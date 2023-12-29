package pageelements;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AbstractMethods;


public class Addaddress extends AbstractMethods {

	public Addaddress(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = " //span[@class='navFooterBackToTopText']")
	WebElement backtotop;

	@FindBy(xpath = "//a[text()='Help']")
	WebElement helpbutton;

	@FindBy(xpath = "(//div[@class='a-box-inner'])[3]")
	WebElement manageaddress;

	@FindBy(xpath = "//div[@class='a-box first-desktop-address-tile']")
	WebElement addaddress;

	@FindBy(xpath = "//*[text()='Add a new address']")
	WebElement addaddressmessage;

	@FindBy(id = "address-ui-widgets-enterAddressFullName")
	WebElement fullname;

	@FindBy(id = "address-ui-widgets-enterAddressPhoneNumber")
	WebElement mobilenum;

	@FindBy(id = "address-ui-widgets-enterAddressPostalCode")
	WebElement pincode;

	@FindBy(id = "address-ui-widgets-enterAddressLine1")
	WebElement addaddress1;

	@FindBy(id = "address-ui-widgets-enterAddressLine2")
	WebElement address2;

	@FindBy(id = "address-ui-widgets-landmark")
	WebElement landmark;

	@FindBy(id = "address-ui-widgets-enterAddressCity")
	WebElement city;

	@FindBy(id = "select2-address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId-container")
	WebElement state;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	WebElement entercity;

	@FindBy(xpath = "select2-address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId-result-hztw-TELANGANA")
	WebElement selectstate;

	@FindBy(xpath = "(//input[@class='a-button-input'])[3]")
	WebElement addaddressbutton;

	@FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
	WebElement hoveraccountlist;

	@FindBy(xpath = "//span[text()='Sign Out']")
	WebElement signout;

	public void addaddress() throws IOException {
		implicitlywaitmethod();

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", backtotop);
			helpbutton.click();
			manageaddress.click();

			Loginpage lp = new Loginpage(driver);
			lp.signin();

			addaddress.click();

			fullname.sendKeys("Mohitha");
			mobilenum.sendKeys("8475961546");
			pincode.sendKeys("547896");

			js.executeScript("arguments[0].scrollIntoView();", addaddress1);

			addaddress1.sendKeys("hyderbad");
			address2.sendKeys("hyd");
			landmark.sendKeys("gsd");
			city.sendKeys("Hyd");
			state.click();
			entercity.sendKeys("Hyd");
			selectstate.click();
			addaddressbutton.click();

			Hoveranyelement(hoveraccountlist);
			signout.click();

			System.out.println("Test is executed successfully");

		} catch (Exception e) {
			System.out.println("adding address");
		}
	}

}
