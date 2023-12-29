package pageelements;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AbstractMethods;


public class Loginpage extends AbstractMethods {

	public Loginpage(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[text()='Sign in'])[1]")
	WebElement signinbutton;
	
    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']") 
    WebElement HoverSignIN;
	
	@FindBy(id = "ap_email")
	WebElement emailaddress;	

	@FindBy(xpath = "//*[@id=\"ap_password\"]")
	WebElement password;	

	@FindBy(id = "continue")
	WebElement continuebutton;
	
	@FindBy(id = "signInSubmit")
	WebElement signin;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement checkbox;
	
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']") 
	WebElement hoveraccountlist ;
	
	@FindBy(xpath="//span[text()='Sign Out']")
	WebElement signout ;
	
	public void signin() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		try {

			emailaddress.sendKeys("mohitha@gmail.com");
			continuebutton.click();
			password.sendKeys("Mohitha%489");
			signin.click();
		} catch (Exception e) {
			System.out.println("Exception in signing in the amazon website");
		}
	}
	public void signout() {
		try {
			Hoveranyelement(hoveraccountlist);
			signout.click();
		} catch (Exception e) {
		}
	}
}
