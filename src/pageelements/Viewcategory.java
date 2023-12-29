package pageelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AbstractMethods;

public class Viewcategory extends AbstractMethods {
	WebDriver driver;

	public Viewcategory(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//span[text() ='All'])[2]")
	public WebElement all;
	
	@FindBy(xpath = "//a[@data-menu-id='11']")
	public WebElement women;

	@FindBy(xpath = "//a[text() ='Clothing']")
	public WebElement clothing;
	
	@FindBy(xpath = "//span[text() ='Western Wear']")
	public WebElement Western;
	
	@FindBy(xpath = "//span[text() ='Dresses']")
	public WebElement dresses;
	
	public void view() {
		implicitlywaitmethod();
		try {
		women.click();
		all.click();
		clothing.click();
		System.out.println("confirm text 'WOMEN - TOPS PRODUCTS'");
		Western.click();
		dresses.click();
		} catch (Exception e) {
		System.out.println("user is navigated to that category page");
	}

}

}
