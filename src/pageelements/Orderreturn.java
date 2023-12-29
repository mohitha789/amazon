package pageelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AbstractMethods;

public class Orderreturn extends AbstractMethods {

	public Orderreturn(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[@class='nav-line-2'])[2]")
	WebElement returns_order;

	@FindBy(xpath = "//div[@class='a-column a-span6']/child::h1")
	WebElement yoursorder;

	@FindBy(xpath = "//li[@class='page-tabs__tab page-tabs__tab--selected']")
	WebElement orders;

	@FindBy(xpath = "//span[@id='a-autoid-1-announce']")
	WebElement dropdown;

	@FindBy(xpath = "//a[@id='time-filter_2']")
	WebElement year;

	@FindBy(xpath = "(//div[@class='a-box-inner'])[1]")
	WebElement orderplacedBox;

	@FindBy(id = "ap_email")
	WebElement emailaddress;

	@FindBy(xpath = "//*[@id=\"ap_password\"]")
	WebElement password;

	@FindBy(id = "continue")
	WebElement continuebutton;

	@FindBy(id = "signInSubmit")
	WebElement signin;

	public void returnsandorders() {
		implicitlywaitmethod();

		try {
			returns_order.click();
			emailaddress.sendKeys("mohitha@gmail.com");
			continuebutton.click();
			password.sendKeys("Mohitha#145");
			signin.click();
			orders.click();
			dropdown.click();
			year.click();
			System.out.println("Test is executed successfully");

		} catch (Exception e) {
			System.out.println("checking returns");
		}
	}
}
