package pageelements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.AbstractMethods;

public class Membershippage extends AbstractMethods {
	WebDriver driver;

	public Membershippage(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "nav-hamburger-menu")
	WebElement hamburgerclick;

	@FindBy(xpath = "(//a[text()='Email'])")
	WebElement email;

	@FindBy(xpath = "//h1[text()='Your Email Subscriptions']")
	WebElement emaisubscriptions;

	@FindBy(xpath = "(//a[text()='Memberships & Subscriptions'])")
	WebElement membershipsubscriptionbutton;

	@FindBy(xpath = "//h1[@class='a-size-extra-large a-color-base']")
	WebElement membershipmessage;

	@FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
	WebElement hoveraccountlist;

	@FindBy(xpath = "//span[text()='Sign Out']")
	WebElement signout;

	public void membership() throws IOException {
		implicitlywaitmethod();
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);
		try {
			hamburgerclick.click();
			membershipsubscriptionbutton.click();
			Loginpage lp = new Loginpage(driver);
			lp.signin();
			Hoveranyelement(hoveraccountlist);
			signout.click();
			String url = prop.getProperty("url");
			driver.get(url);

			System.out.println("test is executed successfully");
		} catch (Exception e) {
			System.out.println("Memebership subscription");
		}
	}

}
