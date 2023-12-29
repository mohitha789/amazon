package pageelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AbstractMethods;

public class Createaccount extends AbstractMethods {

	public Createaccount(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

@FindBy(xpath = "(//span[text()='Sign in'])[1]")WebElement signinbutton;
	
	@FindBy(id = "createAccountSubmit") WebElement createaccount;
	
	@FindBy(id = "ap_customer_name")WebElement name;

	@FindBy(id = "ap_phone_number")WebElement phonenum;	
	
	@FindBy(id = "ap_email")WebElement emailaddress;	

	@FindBy(id = "ap_password")WebElement password;	

	@FindBy(id = "continue")WebElement continuebutton;
	
	@FindBy(id = "signInSubmit")WebElement signin;
	
	public void createaccount() {
		implicitlywaitmethod();
		try {
			signinbutton.click();
			createaccount.click();
			name.sendKeys("Mohitha");
			phonenum.sendKeys("8456123987");
			emailaddress.sendKeys("mohitha@gmail.com");
			password.sendKeys("Mohitha#145");
			continuebutton.click();
			signin.click();
		}catch (Exception e) {
			System.out.println("create account");
		}
	}
}
