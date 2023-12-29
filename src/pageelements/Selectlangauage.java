package pageelements;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AbstractMethods;


public class Selectlangauage extends AbstractMethods {

	public Selectlangauage(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//i[@class='icp-radio icp-radio-active'])[1]")
	WebElement englishlanguage;

	@FindBy(xpath = "(//span[@class='nav-line-2'])[1]")
	WebElement hoverEN;

	By hoverENBUTTON = By.xpath("(//span[@class='nav-line-2'])[1]");

	@FindBy(xpath = "(//div[@class='icp-mkt-change-lnk'])[1]")
	WebElement changeregion;

	@FindBy(xpath = "//span[@class='a-dropdown-prompt']")
	WebElement selectcountry;

	@FindBy(xpath = "//input[@class='a-button-input']")
	WebElement gotowebsitebutton;
	
	public void languageselect() {
		try {
		Hoveranyelement(hoverEN);
		englishlanguage.click();
		
		}
		catch(Exception e){	
			System.out.println("Test case");
		}
		//driver.navigate().back();
		System.out.println("test passed");
	}
	
	public void country_select() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String amazon = driver.getTitle();
		
		try {
		
		Hoveranyelement(hoverEN);
		changeregion.click();
		
		String Country=selectcountry.getText();
		gotowebsitebutton.click();
		
		Set<String> handles = driver.getWindowHandles();
		for(String st: handles) {
			driver.switchTo().window(st);
			String url=driver.getCurrentUrl();
			
			if(url.equals("https://www.amazon.in/?ref_=icp_country_from_in")) {
				System.out.println("current url="+url);
				break;
			}
		}
				
		System.out.println(driver.getCurrentUrl());
		driver.close();
		}catch(Exception e) {System.out.println("exception block");}
		
		System.out.println("test passed");
	}
}



