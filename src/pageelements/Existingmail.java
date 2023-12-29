package pageelements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AbstractMethods;

public class Existingmail extends AbstractMethods{
	WebDriver driver;
	
	public Existingmail(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@href='/login']")
	public WebElement login;

	@FindBy(xpath = "//input[@name='email']")
	public WebElement enteremail;
	
	@FindBy(xpath = "//input[@type='password']")
	public WebElement Password;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement submitbutton;
	
	public void existingdetails() {
		implicitlywaitmethod();	
		login.click();
		enteremail.sendKeys("mohitha@gmail.com");
		Password.sendKeys("Mohitha146");
		submitbutton.sendKeys(Keys.ENTER);
		System.out.println("Verify error 'Email Address already exist!' is visible");
		
	}
}
