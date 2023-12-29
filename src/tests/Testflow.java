package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageelements.Loginpage;
import pageelements.Selectlangauage;
import pageelements.Subscription;
import pageelements.Addcart;
import pageelements.Amazonrewards;
import pageelements.Createaccount;
import pageelements.Mobilerecharge;
import pageelements.Orderreturn;
import pageelements.Scrolluppage;
import pageelements.Scrollupwithoutarrow;
import pageelements.Electronicspage;
import pageelements.Existingmail;
import pageelements.Addaddress;
import pageelements.Viewcategory;
import pageelements.Membershippage;

public class Testflow {
	WebDriver driver;

	Loginpage lp;
	Selectlangauage sl;
	Addcart ac;
	Amazonrewards ar;
	Subscription sb;
	Mobilerecharge mr;
	Electronicspage ep;
	Addaddress ad;
	Createaccount ca;
	Orderreturn or;
	Scrolluppage su;
	Scrollupwithoutarrow sw;
	Viewcategory vc;
	Existingmail em;
	Membershippage mp;

	@BeforeTest
	public void setup() throws IOException {
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		String url = prop.getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void signin() {
		lp = new Loginpage(driver);
		lp.signin();
	}

	@Test(priority = 2)
	public void Createaccount() {
		ca = new Createaccount(driver);
		ca.createaccount();
	}
	@Test(priority = 3)
	public void Existingmail() {
		em = new Existingmail(driver);
		em.existingdetails();
	}

	@Test(priority = 4)
	public void Selectlangauage() {
		sl = new Selectlangauage(driver);
		sl.languageselect();
		sl.country_select();
	}

	@Test(priority = 5)
	public void Addcart() throws InterruptedException {
		ac = new Addcart(driver);
		ac.addtowishlist();
	}

	@Test(priority = 6)
	public void Subscription() throws InterruptedException, IOException {
		sb = new Subscription(driver);
		sb.subscriptionmail();
		sb.membershipsubscriptions();
	}

	@Test(priority = 7)
	public void Amazonrewards() throws InterruptedException, IOException {
		ar = new Amazonrewards(driver);
		ar.amazonpayrewards();
	}

	@Test(priority = 8)
	public void Mobilerecharge() throws InterruptedException, IOException {
		mr = new Mobilerecharge(driver);
		mr.mobilerecharge();
	}

	@Test(priority = 9)
	public void Electronicspage() throws InterruptedException, IOException {
		ep = new Electronicspage(driver);
		ep.searchelectronics();
	}

	@Test(priority = 10)
	public void Addaddress() throws InterruptedException, IOException {
		ad = new Addaddress(driver);
		ad.addaddress();
	}
	@Test(priority = 11)
	public void Orderreturn() throws InterruptedException, IOException {
		or = new Orderreturn(driver);
		or.returnsandorders();
	}
	@Test(priority = 12)
	public void Scrolluppage() throws InterruptedException, IOException {
		su = new Scrolluppage(driver);
		su.scrollupdown_usingarrow();
	}
	@Test(priority = 13)
	public void Scrollupwithoutarrow() throws InterruptedException, IOException {
		sw = new Scrollupwithoutarrow(driver);
		sw.withoutarrow();
	}
	@Test(priority = 14)
	public void Viewcategory() throws InterruptedException, IOException {
		vc = new Viewcategory(driver);
		vc.view();
	}
	@Test(priority = 15)
	public void Membershippage() throws InterruptedException, IOException {
		mp = new Membershippage(driver);
		mp.membership();
	}
}
