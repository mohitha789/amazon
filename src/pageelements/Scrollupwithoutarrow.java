package pageelements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AbstractMethods;

public class Scrollupwithoutarrow extends AbstractMethods {
	WebDriver driver;

	public Scrollupwithoutarrow(WebDriver driverhere) {
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

	public void withoutarrow() throws IOException {
		implicitlywaitmethod();
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);

		try {
			homepage.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", subscriptiontext);
			js.executeScript("arguments[0].scrollIntoView();", homepage);
			subscriptiontext.sendKeys("Subscription");
			scrollup.click();
			message.sendKeys("full fledged");
			System.out.println("Test is executed succesfully");
		} catch (Exception e) {
			System.out.println("Test execution");
		}
	}

}
