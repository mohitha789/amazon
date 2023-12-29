package pageelements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.AbstractMethods;

public class Mobilerecharge extends AbstractMethods {

	public Mobilerecharge(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "nav-hamburger-menu")
	WebElement hamburgerclick;

	@FindBy(xpath = "(//a[text()='Amazon Pay'])[2]")
	WebElement amazonpay;

	@FindBy(xpath = "//span[text()='Mobile Recharge']")
	WebElement mobilerecharge;

	@FindBy(xpath = "//input[@id='mobileNumberTextInputId']")
	WebElement mobilenum;

	@FindBy(xpath = "//a[@id='operatorCircleLink']")
	WebElement EditOperator;

	@FindBy(xpath = "(//i[@class='a-icon a-icon-radio'])[5]")
	WebElement jiooperator;

	@FindBy(xpath = "(//i[@class='a-icon a-icon-radio'])[8]")
	WebElement telanganacicle;

	@FindBy(xpath = "(//a[@class='a-popover-trigger a-declarative'])[2]")
	WebElement viewplans;

	@FindBy(xpath = "//input[@value='Popular~19~NA~Active plan~1015084~KOMPARIFY']")
	WebElement popularplan;

	@FindBy(xpath="//button[@id='buyButtonNative']") WebElement continuebutton;

	public void mobilerecharge() throws IOException {
		implicitlywaitmethod();
		Properties prop = new Properties();
	    FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+("\\src\\testData\\GlobalInput.properties"));
	    prop.load(fs);
		try {
			hamburgerclick.click();
			amazonpay.click();
			mobilerecharge.click();
			Loginpage lp = new Loginpage(driver);
			lp.signin();
			
			String mobilenumber = prop.getProperty("mobilenumber");
			mobilenum.sendKeys(mobilenumber);
			EditOperator.click();
			jiooperator.click();
			telanganacicle.click();
			viewplans.click();
			popularplan.click();
			continuebutton.click();
			}
			 catch (Exception e) {
					System.out.println("mobile recharge");
				}
}
	}
