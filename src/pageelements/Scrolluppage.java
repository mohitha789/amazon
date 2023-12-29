package pageelements;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.AbstractMethods;


public class Scrolluppage extends AbstractMethods {

	public Scrolluppage(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='fa fa-home']/parent::a")
	WebElement homepage;

	@FindBy(xpath = "//*[contains(text(),'Subscription')]")
	WebElement subscriptiontext;

	@FindBy(xpath = "//a[@id='scrollUp']")
	WebElement scrollup;

	@FindBy(xpath = "//*[contains(text(),'Full-Fledged')]")
	WebElement message;

	public void scrollupdown_usingarrow() throws IOException {
		implicitlywaitmethod();
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);

		try {
			homepage.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", subscriptiontext);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			wait.until(ExpectedConditions.elementToBeClickable(scrollup));
			subscriptiontext.sendKeys("Subscription");
			scrollup.click();
			message.sendKeys("full fledged");
			System.out.println("Test is  executed succesfully");
		} catch (Exception e) {
			System.out.println("test is execution");
		}
	}

}
