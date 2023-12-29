package pageelements;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AbstractMethods;

public class Amazonrewards extends AbstractMethods {

	public Amazonrewards(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "nav-hamburger-menu")
	WebElement hamburgerclick;

	@FindBy(xpath = "//div[text()='Audible Audiobooks']/parent::a")
	WebElement audiobooks;

	@FindBy(xpath = "(//a[text()='Amazon Pay'])[2]")
	WebElement amazonpay;

	@FindBy(xpath = "//span[text()='Rewards']")
	WebElement rewards;

	@FindBy(xpath = "//a[@id='a-autoid-1-announce']")
	WebElement signintounlockbutton;

	@FindBy(xpath = "//span[@class='a-size-extra-large show-cashback-earned']")
	WebElement cashbackearned;

	@FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
	WebElement hoveraccountlist;

	@FindBy(xpath = "//span[text()='Sign Out']")
	WebElement signout;

	public void amazonpayrewards() {
		implicitlywaitmethod();

		try {
			hamburgerclick.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", audiobooks);

			amazonpay.click();
			rewards.click();
			signintounlockbutton.click();
			Loginpage lp = new Loginpage(driver);
			lp.signin();
			String cashback = cashbackearned.getText();
			System.out.println(cashback);
			Hoveranyelement(hoveraccountlist);
			signout.click();
			Properties prop = new Properties();
			FileInputStream fs = new FileInputStream(
					System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
			prop.load(fs);
			String url = prop.getProperty("url");
			driver.get(url);
			System.out.println("Test is  executed successfully");
		} catch (Exception e) {
			System.out.println("selectig rewards");
		}

	}

}
